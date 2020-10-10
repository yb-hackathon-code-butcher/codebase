package io.github.butcher.butcher.back.scheduler;

import io.github.butcher.butcher.back.config.AppGameProperties;
import io.github.butcher.butcher.back.domain.Game;
import io.github.butcher.butcher.back.domain.Option;
import io.github.butcher.butcher.back.game.event.StartEvaluationEvent;
import io.github.butcher.butcher.back.game.event.StopGameEvent;
import io.github.butcher.butcher.back.service.GameService;
import io.github.butcher.butcher.back.service.OptionService;
import io.github.butcher.butcher.back.socket.event.GameEndedEvent;
import io.github.butcher.butcher.back.socket.event.NextRoundEvent;
import io.github.butcher.butcher.back.socket.event.RoundEndedEvent;
import io.github.butcher.butcher.back.util.TimeUtil;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Component;

@Component
public class NextRoundScheduler {

  private static final Logger LOGGER = LoggerFactory.getLogger(NextRoundScheduler.class);
  private final AppGameProperties appGameProperties;
  private final GameService gameService;
  private final OptionService optionService;
  private final TaskScheduler taskScheduler;
  private final ApplicationEventPublisher applicationEventPublisher;
  private boolean stopGame = false;

  public NextRoundScheduler(AppGameProperties appGameProperties, GameService gameService,
      OptionService optionService,
      TaskScheduler taskScheduler,
      ApplicationEventPublisher applicationEventPublisher) {
    this.appGameProperties = appGameProperties;
    this.gameService = gameService;
    this.optionService = optionService;
    this.taskScheduler = taskScheduler;
    this.applicationEventPublisher = applicationEventPublisher;
  }

  @EventListener
  public void nextRound(NextRoundEvent nextRoundEvent) {
    LOGGER.info("Scheduling round end to {}", nextRoundEvent.getEndTime());

    taskScheduler
        .schedule(() -> applicationEventPublisher.publishEvent(new StartEvaluationEvent(this)),
            TimeUtil.localDateTimeToInstant(nextRoundEvent.getEndTime()));
  }

  @EventListener
  public void roundEnded(RoundEndedEvent roundEndedEvent) {
    LOGGER.debug("Round has ended, evaluating stop mode: {}", stopGame);

    if (stopGame) {
      wereInTheEndgameNow();
    } else {
      isThisTheOne();
    }
  }

  private void wereInTheEndgameNow() {
    LOGGER.info("We're in the endgame now.");

    applicationEventPublisher.publishEvent(new GameEndedEvent(gameService.determineWinnerTeam()));
  }

  private void isThisTheOne() {
    LOGGER.debug("Calculating next round, starting");

    Game currentGame = gameService.getCurrentGame();

    List<Option> team1Options = optionService.getNextOptions(currentGame.getTeam1Zone());
    List<Option> team2Options = optionService.getNextOptions(currentGame.getTeam2Zone());

    publishNextRoundPerTeam(team1Options, currentGame.getTeam1().getId());
    publishNextRoundPerTeam(team2Options, currentGame.getTeam2().getId());
  }

  private void publishNextRoundPerTeam(List<Option> options, Long teamId) {
    LOGGER.debug("Publishing next options for team {}", teamId);

    taskScheduler
        .schedule(() -> applicationEventPublisher
                .publishEvent(
                    new NextRoundEvent(options, appGameProperties.getRoundDurationSeconds(), teamId)),
            TimeUtil.localDateTimeToInstant(LocalDateTime.now()
                .plus(appGameProperties.getRoundDelaySeconds(), ChronoUnit.SECONDS)));
  }

  @EventListener
  public void stopGame(StopGameEvent stopGameEvent) {
    LOGGER.info("Game stop signal received, will shutdown gracefully");

    this.stopGame = true;
  }
}
