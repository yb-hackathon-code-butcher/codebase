package io.github.butcher.butcher.back.scheduler;

import io.github.butcher.butcher.back.domain.Game;
import io.github.butcher.butcher.back.game.event.GameScheduledEvent;
import io.github.butcher.butcher.back.service.GameService;
import io.github.butcher.butcher.back.socket.event.GameEndedEvent;
import io.github.butcher.butcher.back.socket.event.GameStartsEvent;
import io.github.butcher.butcher.back.util.TimeUtil;
import java.time.LocalDateTime;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadLocalRandom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Component;

@Component
public class NextGameScheduler {

  private static final Logger LOGGER = LoggerFactory.getLogger(NextGameScheduler.class);
  private final GameService gameService;
  private final TaskScheduler taskScheduler;
  private final ApplicationEventPublisher applicationEventPublisher;
  private Game currentScheduledGame;
  private ScheduledFuture<?> schedule;

  public NextGameScheduler(GameService gameService, TaskScheduler taskScheduler,
      ApplicationEventPublisher applicationEventPublisher) {
    this.gameService = gameService;
    this.taskScheduler = taskScheduler;
    this.applicationEventPublisher = applicationEventPublisher;
  }

  @EventListener
  public void scheduleInitialGameStart(ApplicationReadyEvent applicationReadyEvent) {
    LOGGER.info("Application started, initiating game schedule");

    scheduleNextGame();
  }

  @EventListener
  public void scheduleNextGameStart(GameEndedEvent gameEndedEvent) {
    LOGGER.info("Looking for the next game");

    scheduleNextGame();
  }

  private void scheduleNextGame() {
    Game nextGame = gameService.getNextGame();

    if (nextGame != null) {
      scheduleGameStart(nextGame);
    }
  }

  @EventListener
  public void onGameScheduled(GameScheduledEvent gameScheduledEvent) {
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("A new game has been scheduled, evaluation start time: {}",
          gameScheduledEvent.getGame().getStartTime());
    }

    Game newScheduledGame = gameScheduledEvent.getGame();
    LocalDateTime newStartTime = TimeUtil.timestampToLocalDateTime(newScheduledGame.getStartTime());

    if (currentScheduledGame == null) {
      scheduleGameStart(newScheduledGame);
    }

    if (newStartTime
        .isBefore(TimeUtil.timestampToLocalDateTime(currentScheduledGame.getStartTime()))
        && !newStartTime.isBefore(LocalDateTime.now())) {
      LOGGER.debug("Game will start soon, rescheduling..");

      schedule.cancel(false);

      scheduleGameStart(newScheduledGame);
    }
  }


  private void scheduleGameStart(Game newScheduledGame) {
    currentScheduledGame = newScheduledGame;

    LOGGER.info("Scheduling game start to {}", currentScheduledGame.getStartTime());

    Long startingTeamId = randomOfTwo(currentScheduledGame.getTeam1().getId(),
        currentScheduledGame.getTeam2().getId());
    LocalDateTime endTime = TimeUtil.timestampToLocalDateTime(currentScheduledGame.getStartTime());

    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("Team {} is gonna start", startingTeamId);
    }

    gameService.setStartingTeam(currentScheduledGame, startingTeamId);

    schedule = taskScheduler.schedule(() -> {
      LOGGER.info("Game starts!");
      applicationEventPublisher.publishEvent(new GameStartsEvent(startingTeamId, endTime));
    }, currentScheduledGame.getStartTime().toInstant());
  }

  private Long randomOfTwo(Long team1Id, Long team2Id) {
    return new Long[]{team1Id, team2Id}[ThreadLocalRandom.current().nextInt(0, 2)];
  }
}
