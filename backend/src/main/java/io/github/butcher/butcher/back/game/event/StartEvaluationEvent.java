package io.github.butcher.butcher.back.game.event;

import org.springframework.context.ApplicationEvent;

public class StartEvaluationEvent extends ApplicationEvent {

  public StartEvaluationEvent(Object source) {
    super(source);
  }
}
