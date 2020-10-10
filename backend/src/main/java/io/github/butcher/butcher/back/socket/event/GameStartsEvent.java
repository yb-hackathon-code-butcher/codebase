package io.github.butcher.butcher.back.socket.event;

import io.github.butcher.butcher.back.socket.GameEvent;
import java.time.LocalDateTime;

public class GameStartsEvent implements SocketIOEvent {

  private Long startTeamId;
  private LocalDateTime endTime;

  public GameStartsEvent(Long startTeamId, LocalDateTime endTime) {
    this.startTeamId = startTeamId;
    this.endTime = endTime;
  }

  public Long getStartTeamId() {
    return startTeamId;
  }

  public void setStartTeamId(Long startTeamId) {
    this.startTeamId = startTeamId;
  }

  public LocalDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
  }

  @Override
  public String getStringId() {
    return GameEvent.GAME_STARTS.getStringId();
  }

  @Override
  public Long getTeamId() {
    // This event is not team restricted
    return null;
  }

  @Override
  public String toString() {
    return "GameStartsEvent{" +
        "startTeamId=" + startTeamId +
        ", endTime=" + endTime +
        '}';
  }
}
