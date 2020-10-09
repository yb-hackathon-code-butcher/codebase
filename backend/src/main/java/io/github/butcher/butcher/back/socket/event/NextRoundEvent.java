package io.github.butcher.butcher.back.socket.event;

import java.time.LocalDateTime;

public class NextRoundEvent {

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
}
