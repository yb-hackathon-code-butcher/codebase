package io.github.butcher.butcher.back.domain;

import java.time.LocalDateTime;

public class Game {

  private LocalDateTime startTime = LocalDateTime.now();

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }
}
