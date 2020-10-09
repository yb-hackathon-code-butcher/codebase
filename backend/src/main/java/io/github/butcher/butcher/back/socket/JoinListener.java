package io.github.butcher.butcher.back.socket;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import io.github.butcher.butcher.back.socket.event.JoinEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JoinListener extends AbstractSocketIOEventListener<JoinEvent> {

  private static final Logger LOGGER = LoggerFactory.getLogger(JoinListener.class);

  public JoinListener(SocketIOServer socketIOServer) {
    super(socketIOServer);
  }

  @Override
  protected void registerListener(SocketIOServer socketIOServer) {
    socketIOServer
        .addEventListener(GameEvent.JOIN.getStringId(), JoinEvent.class, this);
  }

  @Override
  public void onData(SocketIOClient socketIOClient, JoinEvent joinEvent,
      AckRequest ackRequest) throws Exception {
    LOGGER.debug("{} received: {}", joinEvent.getClass().getSimpleName(), joinEvent);

    // TODO
  }
}
