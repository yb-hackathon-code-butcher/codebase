package io.github.butcher.butcher.back.service.dto;

import java.util.Date;

public class GameDTO {

  private Long id;
  private Long team1Id;
  private Long team2Id;
  private Date startTime;
  private Date endTime;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
