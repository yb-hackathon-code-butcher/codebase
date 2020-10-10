package io.github.butcher.butcher.back.socket;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import io.github.butcher.butcher.back.game.Voter;
import io.github.butcher.butcher.back.socket.event.VoteEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class VoteListener extends AbstractSocketIOEventListener<VoteEvent> {

  private static final Logger LOGGER = LoggerFactory.getLogger(VoteListener.class);

  private final Voter voter;

  public VoteListener(SocketIOServer socketIOServer,Voter voter) {
    super(socketIOServer);

    this.voter = voter;
  }

  @Override
  protected void registerListener(SocketIOServer socketIOServer) {
    socketIOServer
        .addEventListener(GameEvent.VOTE.getStringId(), VoteEvent.class, this);
  }

  @Override
  public void onData(SocketIOClient socketIOClient, VoteEvent voteEvent,
      AckRequest ackRequest) throws Exception {
    LOGGER.debug("{} received: {}", voteEvent.getClass().getSimpleName(), voteEvent);

    // TODO: Security checK!

    voter.vote(voteEvent.getTeamId(),voteEvent.getVoteId());
  }
}
