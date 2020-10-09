package io.github.butcher.butcher.back.scheduler;

import io.github.butcher.butcher.back.admin.event.GameScheduledEvent;
import io.github.butcher.butcher.back.domain.Game;
import io.github.butcher.butcher.back.service.GameService;
import io.github.butcher.butcher.back.socket.event.GameEndedEvent;
import io.github.butcher.butcher.back.socket.event.GameStartsEvent;
import io.github.butcher.butcher.back.util.TimeUtil;
import java.time.LocalDateTime;
import java.util.concurrent.ScheduledFuture;
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

  private Game currentScheduledGame;
  private ScheduledFuture<?> schedule;

  private final GameService gameService;
  private final TaskScheduler taskScheduler;
  private final ApplicationEventPublisher applicationEventPublisher;

  public NextGameScheduler(GameService gameService, TaskScheduler taskScheduler,
      ApplicationEventPublisher applicationEventPublisher) {
    this.gameService = gameService;
    this.taskScheduler = taskScheduler;
    this.applicationEventPublisher = applicationEventPublisher;
  }

  @EventListener
  public void scheduleInitialGameStart(ApplicationReadyEvent applicationReadyEvent) {
    LOGGER.info("Application started.. initiating game schedule");

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
    Game newScheduledGame = gameScheduledEvent.getGame();
    LocalDateTime newStartTime = TimeUtil.timestampToLocalDateTime(newScheduledGame.getStartTime());

    if (currentScheduledGame == null) {
      scheduleGameStart(newScheduledGame);
    }

    if (newStartTime
        .isBefore(TimeUtil.timestampToLocalDateTime(currentScheduledGame.getStartTime()))
        && !newStartTime.isBefore(LocalDateTime.now())) {
      LOGGER.debug("Rescheduling..");

      schedule.cancel(false);

      scheduleGameStart(newScheduledGame);
    }
  }


  private void scheduleGameStart(Game newScheduledGame) {
    currentScheduledGame = newScheduledGame;

    LOGGER.info("Scheduling game start to {}", currentScheduledGame.getStartTime());

    schedule = taskScheduler.schedule(() -> {
      LOGGER.info("Game starts!");
      applicationEventPublisher.publishEvent(new GameStartsEvent(currentScheduledGame));
    }, currentScheduledGame.getStartTime().toInstant());
  }
}
