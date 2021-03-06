package io.github.butcher.butcher.back.game.event;

import io.github.butcher.butcher.back.domain.Game;
import org.springframework.context.ApplicationEvent;

public class GameScheduledEvent extends ApplicationEvent {

  private final Game game;

  public GameScheduledEvent(Object source, Game game) {
    super(source);

    this.game = game;
  }

  public Game getGame() {
    return this.game;
  }

  @Override
  public String toString() {
    return "GameScheduledEvent{" +
        "game=" + game +
        '}';
  }
}
