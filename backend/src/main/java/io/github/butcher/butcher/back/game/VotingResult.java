package io.github.butcher.butcher.back.game;

public class VotingResult {

  private Long zoneId;
  private Boolean ballPossession;

  public VotingResult(Long zoneId, Boolean ballPossession) {
    this.zoneId = zoneId;
    this.ballPossession = ballPossession;
  }

  public Long getZoneId() {
    return zoneId;
  }

  public void setZoneId(Long zoneId) {
    this.zoneId = zoneId;
  }

  public Boolean getBallPossession() {
    return ballPossession;
  }

  public void setBallPossession(Boolean ballPossession) {
    this.ballPossession = ballPossession;
  }
}
