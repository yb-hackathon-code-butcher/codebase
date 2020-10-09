package io.github.butcher.butcher.back.socket.event;

import io.github.butcher.butcher.back.socket.GameEvent;

public class VoteEvent implements SocketIOEvent {

  private Long voteId;

  public Long getVoteId() {
    return voteId;
  }

  public void setVoteId(Long voteId) {
    this.voteId = voteId;
  }

  @Override
  public String getStringId() {
    return GameEvent.VOTE.getStringId();
  }
}
