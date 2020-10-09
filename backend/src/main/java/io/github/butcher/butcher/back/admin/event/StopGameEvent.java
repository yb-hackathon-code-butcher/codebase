package io.github.butcher.butcher.back.admin.event;

import org.springframework.context.ApplicationEvent;

public class StopGameEvent extends ApplicationEvent {

  public StopGameEvent(Object source) {
    super(source);
  }
}
