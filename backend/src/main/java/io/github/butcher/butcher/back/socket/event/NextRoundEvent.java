package io.github.butcher.butcher.back.socket.event;

import io.github.butcher.butcher.back.socket.GameEvent;
import java.time.LocalDateTime;

public class NextRoundEvent implements SocketIOEvent {

  private String[] options;
  private LocalDateTime endTime;

  public String[] getOptions() {
    return options;
  }

  public void setOptions(String[] options) {
    this.options = options;
  }

  public LocalDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
  }

  @Override
  public String getStringId() {
    return GameEvent.NEXT_ROUND.getStringId();
  }
}
