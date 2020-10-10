package io.github.butcher.butcher.back.socket.event;

import io.github.butcher.butcher.back.game.VotingResult;
import io.github.butcher.butcher.back.socket.GameEvent;
import java.util.Arrays;

public class RoundEndedEvent implements SocketIOEvent {

  private VotingResult votingResult;
  private Long[] eventIds;

  public RoundEndedEvent(VotingResult votingResult, Long[] eventIds) {
    this.votingResult = votingResult;
    this.eventIds = eventIds;
  }

  public VotingResult getVotingResult() {
    return votingResult;
  }

  public void setVotingResult(
      VotingResult votingResult) {
    this.votingResult = votingResult;
  }

  public Long[] getEventIds() {
    return eventIds;
  }

  public void setEventIds(Long[] eventIds) {
    this.eventIds = eventIds;
  }

  @Override
  public String getStringId() {
    return GameEvent.ROUND_ENDED.getStringId();
  }

  @Override
  public Long getTeamId() {
    // TODO: Is this team relevant?
    return null;
  }

  @Override
  public String toString() {
    return "RoundEndedEvent{" +
        "votingResult=" + votingResult +
        ", eventIds=" + Arrays.toString(eventIds) +
        '}';
  }
}
