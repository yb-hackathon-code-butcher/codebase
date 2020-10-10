package io.github.butcher.butcher.back.socket.event;

import io.github.butcher.butcher.back.socket.GameEvent;

public class JoinEvent implements SocketIOEvent {

  @Override
  public String getStringId() {
    return GameEvent.JOIN.getStringId();
  }

  @Override
  public Long getTeamId() {
    // This event is not published
    return null;
  }
}
