package io.github.butcher.butcher.back.scheduler;

import io.github.butcher.butcher.back.admin.event.GameScheduledEvent;
import io.github.butcher.butcher.back.domain.Game;
import io.github.butcher.butcher.back.service.GameService;
import io.github.butcher.butcher.back.socket.event.GameStartsEvent;
import java.time.LocalDateTime;
import java.time.ZoneId;
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

    Game nextGame = gameService.getNextGame();

    if (nextGame != null) {
      scheduleGameStart(nextGame);
    }
  }

  @EventListener
  public void onGameScheduled(GameScheduledEvent gameScheduledEvent) {
    Game newScheduledGame = gameScheduledEvent.getGame();
    LocalDateTime newStartTime = newScheduledGame.getStartTime();

    if (currentScheduledGame == null) {
      scheduleGameStart(newScheduledGame);
    }

    if (newStartTime.isBefore(currentScheduledGame.getStartTime())
        && !newStartTime.isBefore(LocalDateTime.now())) {
      LOGGER.debug("Rescheduling..");

      this.schedule.cancel(false);

      scheduleGameStart(newScheduledGame);
    }
  }

  private void scheduleGameStart(Game newScheduledGame) {
    LOGGER.info("Scheduling game start to {}", newScheduledGame.getStartTime());

    this.schedule = taskScheduler.schedule(() -> {
      LOGGER.info("Game starts!");
      // TODO: Start team id?
      applicationEventPublisher.publishEvent(new GameStartsEvent());
    }, newScheduledGame.getStartTime().atZone(ZoneId.systemDefault()).toInstant());
    this.currentScheduledGame = newScheduledGame;
  }
}
