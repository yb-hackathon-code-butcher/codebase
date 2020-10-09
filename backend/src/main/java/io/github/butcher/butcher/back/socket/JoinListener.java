package io.github.butcher.butcher.back.socket;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import io.github.butcher.butcher.back.socket.event.JoinEvent;
import org.springframework.stereotype.Component;

@Component
public class JoinListener extends AbstractSocketIOEventListener<JoinEvent> {

  public JoinListener(SocketIOServer socketIOServer) {
    super(socketIOServer);
  }

  @Override
  protected void registerListener(SocketIOServer socketIOServer) {
    socketIOServer
        .addEventListener(GameEvent.JOIN.getStringId(), JoinEvent.class, this);
  }

  @Override
  public void onData(SocketIOClient socketIOClient, JoinEvent startTeamEvent,
      AckRequest ackRequest) throws Exception {
    // TODO
  }
}
