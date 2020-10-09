package io.github.butcher.butcher.back.socket.event;

import io.github.butcher.butcher.back.socket.GameEvent;

public class RoundEndedEvent implements SocketIOEvent {

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

  @Override
  public String getStringId() {
    return GameEvent.ROUND_ENDED.getStringId();
  }

  public class VoteResult {

    private Integer zoneId;
    private Long ballPossession;

    public Integer getZoneId() {
      return zoneId;
    }

    public void setZoneId(Integer zoneId) {
      this.zoneId = zoneId;
    }

    public Long getBallPossession() {
      return ballPossession;
    }

    public void setBallPossession(Long ballPossession) {
      this.ballPossession = ballPossession;
    }
  }
}
