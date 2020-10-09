package io.github.butcher.butcher.back.socket;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import io.github.butcher.butcher.back.socket.event.VoteEvent;
import org.springframework.stereotype.Component;

@Component
public class VoteListener extends AbstractSocketIOEventListener<VoteEvent> {

  public VoteListener(SocketIOServer socketIOServer) {
    super(socketIOServer);
  }

  @Override
  protected void registerListener(SocketIOServer socketIOServer) {
    socketIOServer
        .addEventListener(GameEvent.VOTE.getStringId(), VoteEvent.class, this);
  }

  @Override
  public void onData(SocketIOClient socketIOClient, VoteEvent startTeamEvent,
      AckRequest ackRequest) throws Exception {
    // TODO
  }
}
