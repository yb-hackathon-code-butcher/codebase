package io.github.butcher.butcher.back.scheduler;

import io.github.butcher.butcher.back.admin.event.StopGameEvent;
import io.github.butcher.butcher.back.socket.event.GameStartsEvent;
import io.github.butcher.butcher.back.util.TimeUtil;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Component;

@Component
public class GameEndScheduler {

  private final TaskScheduler taskScheduler;
  private final ApplicationEventPublisher applicationEventPublisher;

  public GameEndScheduler(TaskScheduler taskScheduler,
      ApplicationEventPublisher applicationEventPublisher) {
    this.taskScheduler = taskScheduler;
    this.applicationEventPublisher = applicationEventPublisher;
  }

  @EventListener
  public void gameStarts(GameStartsEvent gameStartsEvent) {
    taskScheduler.schedule(() ->
            applicationEventPublisher.publishEvent(new StopGameEvent(this)),
        TimeUtil.localDateTimeToInstant(gameStartsEvent.getEndTime()));
  }
}
