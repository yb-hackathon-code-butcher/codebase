package io.github.butcher.butcher.back.socket.event;

import java.time.LocalDateTime;

public class GameStartsEvent {

  private LocalDateTime endTime;

  public LocalDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
  }
}
