package io.github.butcher.butcher.back.service.dto;


import java.util.Date;
import java.util.Map;

public class GameStatsDTO {

  private GameDTO game;
  private Boolean isRunning;
  private Long teamScore1;
  private Long teamScore2;
  private Date roundEndTime;
  private Long[] options;
  private Map<Long, Long> voteDistribution;

  public GameDTO getGame() {
    return game;
  }

  public void setGame(GameDTO game) {
    this.game = game;
  }

  public Boolean getRunning() {
    return isRunning;
  }

  public void setRunning(Boolean running) {
    isRunning = running;
  }

  public Long getTeamScore1() {
    return teamScore1;
  }

  public void setTeamScore1(Long teamScore1) {
    this.teamScore1 = teamScore1;
  }

  public Long getTeamScore2() {
    return teamScore2;
  }

  public void setTeamScore2(Long teamScore2) {
    this.teamScore2 = teamScore2;
  }

  public Date getRoundEndTime() {
    return roundEndTime;
  }

  public void setRoundEndTime(Date roundEndTime) {
    this.roundEndTime = roundEndTime;
  }

  public Long[] getOptions() {
    return options;
  }

  public void setOptions(Long[] options) {
    this.options = options;
  }

  public Map<Long, Long> getVoteDistribution() {
    return voteDistribution;
  }

  public void setVoteDistribution(Map<Long, Long> voteDistribution) {
    this.voteDistribution = voteDistribution;
  }
}
