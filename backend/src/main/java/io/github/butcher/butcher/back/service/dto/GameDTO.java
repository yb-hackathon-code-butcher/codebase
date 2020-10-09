package io.github.butcher.butcher.back.service.dto;

import java.util.Date;

public class GameDTO {

  private Integer team1Id;
  private Integer team2Id;
  private Date startTime;
  private Date endTime;

  public Integer getTeam1Id() {
    return team1Id;
  }

  public void setTeam1Id(Integer team1Id) {
    this.team1Id = team1Id;
  }

  public Integer getTeam2Id() {
    return team2Id;
  }

  public void setTeam2Id(Integer team2Id) {
    this.team2Id = team2Id;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }
}
