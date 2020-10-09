package io.github.butcher.butcher.back.scheduler;

import io.github.butcher.butcher.back.game.event.StopGameEvent;
import io.github.butcher.butcher.back.socket.event.GameStartsEvent;
import io.github.butcher.butcher.back.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Component;

@Component
public class GameEndScheduler {

  private static final Logger LOGGER = LoggerFactory.getLogger(GameEndScheduler.class);

  private final TaskScheduler taskScheduler;
  private final ApplicationEventPublisher applicationEventPublisher;

  public GameEndScheduler(TaskScheduler taskScheduler,
      ApplicationEventPublisher applicationEventPublisher) {
    this.taskScheduler = taskScheduler;
    this.applicationEventPublisher = applicationEventPublisher;
  }

  @EventListener
  public void gameStarts(GameStartsEvent gameStartsEvent) {
    LOGGER.info("Scheduling game end to {}", gameStartsEvent.getEndTime());

    taskScheduler.schedule(() ->
            applicationEventPublisher.publishEvent(new StopGameEvent(this)),
        TimeUtil.localDateTimeToInstant(gameStartsEvent.getEndTime()));
  }
}
