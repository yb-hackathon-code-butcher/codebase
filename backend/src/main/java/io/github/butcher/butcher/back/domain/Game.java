package io.github.butcher.butcher.back.domain;

import java.time.LocalDateTime;

public class Game {

  private LocalDateTime startTime = LocalDateTime.now();
  private Long team1Id;
  private Long team2Id;

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }

  public Long getTeam1Id() {
    return team1Id;
  }

  public void setTeam1Id(Long team1Id) {
    this.team1Id = team1Id;
  }

  public Long getTeam2Id() {
    return team2Id;
  }

  public void setTeam2Id(Long team2Id) {
    this.team2Id = team2Id;
  }
}
