package io.github.butcher.butcher.back.socket.event;

import io.github.butcher.butcher.back.socket.GameEvent;
import java.time.LocalDateTime;

public class GameStartsEvent implements SocketIOEvent {

  private LocalDateTime endTime;

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
}
