package io.github.butcher.butcher.back.socket.event;

public class RoundEndedEvent {

  private VoteResult voteResult;
  private Long[] events;

  public VoteResult getVoteResult() {
    return voteResult;
  }

  public void setVoteResult(
      VoteResult voteResult) {
    this.voteResult = voteResult;
  }

  public Long[] getEvents() {
    return events;
  }

  public void setEvents(Long[] events) {
    this.events = events;
  }

  public static class VoteResult {

    private Integer zoneId;
    private Long ballPossesion;

    public Integer getZoneId() {
      return zoneId;
    }

    public void setZoneId(Integer zoneId) {
      this.zoneId = zoneId;
    }

    public Long getBallPossesion() {
      return ballPossesion;
    }

    public void setBallPossesion(Long ballPossesion) {
      this.ballPossesion = ballPossesion;
    }
  }
}
