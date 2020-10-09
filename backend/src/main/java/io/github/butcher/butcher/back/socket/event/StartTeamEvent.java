package io.github.butcher.butcher.back.socket.event;

import io.github.butcher.butcher.back.socket.GameEvent;

public class StartTeamEvent implements SocketIOEvent {

  private Long teamId;

  public Long getTeamId() {
    return teamId;
  }

  public void setTeamId(Long teamId) {
    this.teamId = teamId;
  }

  @Override
  public String getStringId() {
    return GameEvent.START_TEAM.getStringId();
  }
}
