package io.github.butcher.butcher.back.scheduler;

import io.github.butcher.butcher.back.admin.event.StartEvaluationEvent;
import io.github.butcher.butcher.back.admin.event.StopGameEvent;
import io.github.butcher.butcher.back.config.AppGameProperties;
import io.github.butcher.butcher.back.service.GameService;
import io.github.butcher.butcher.back.service.OptionService;
import io.github.butcher.butcher.back.socket.event.GameEndedEvent;
import io.github.butcher.butcher.back.socket.event.NextRoundEvent;
import io.github.butcher.butcher.back.socket.event.RoundEndedEvent;
import io.github.butcher.butcher.back.util.TimeUtil;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ScheduledFuture;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Component;

@Component
public class NextRoundScheduler {

  private ScheduledFuture<?> schedule;
  private boolean stopGame = false;

  private final AppGameProperties appGameProperties;
  private final GameService gameService;
  private final OptionService optionService;
  private final TaskScheduler taskScheduler;
  private final ApplicationEventPublisher applicationEventPublisher;

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
    schedule = taskScheduler
        .schedule(() -> applicationEventPublisher.publishEvent(new StartEvaluationEvent(this)),
            TimeUtil.localDateTimeToInstant(nextRoundEvent.getEndTime()));
  }

  @EventListener
  public void roundEnded(RoundEndedEvent roundEndedEvent) {
    if (stopGame) {
      wereInTheEndgameNow();
    } else {
      isThisTheOne();
    }
  }

  private void wereInTheEndgameNow() {
    applicationEventPublisher.publishEvent(new GameEndedEvent(gameService.determineWinnerTeam()));
  }

  private void isThisTheOne() {
    schedule = taskScheduler
        .schedule(() -> applicationEventPublisher
            .publishEvent(new NextRoundEvent(optionService.getNextOptions(),
                appGameProperties.getRoundDurationSeconds())), TimeUtil.localDateTimeToInstant(
            LocalDateTime.now()
                .plus(appGameProperties.getRoundDelaySeconds(), ChronoUnit.SECONDS)));
  }

  @EventListener
  public void stopGame(StopGameEvent stopGameEvent) {
    this.stopGame = true;
  }
}
