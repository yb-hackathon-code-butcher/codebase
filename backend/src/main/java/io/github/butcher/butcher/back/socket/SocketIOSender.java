package io.github.butcher.butcher.back.socket;

import com.corundumstudio.socketio.SocketIOServer;
import io.github.butcher.butcher.back.socket.event.SocketIOEvent;
import org.springframework.stereotype.Component;

@Component
public class SocketIOSender {

  private final SocketIOServer socketIOServer;

  public SocketIOSender(SocketIOServer socketIOServer) {
    this.socketIOServer = socketIOServer;
  }

  public <E extends SocketIOEvent> void broadcastEvent(E event) {
    socketIOServer.getBroadcastOperations().sendEvent(event.getStringId(), event);
  }
}
