package io.github.butcher.butcher.back.socket;

import com.corundumstudio.socketio.SocketIOServer;
import io.github.butcher.butcher.back.socket.event.SocketIOEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SocketIOServerOutboundEventListener {

  private final SocketIOServer socketIOServer;

  public SocketIOServerOutboundEventListener(SocketIOServer socketIOServer) {
    this.socketIOServer = socketIOServer;
  }

  @EventListener
  public void broadcastEvent(SocketIOEvent socketIOEvent) {
    // TODO: This must be team specific?
    socketIOServer.getBroadcastOperations()
        .sendEvent(socketIOEvent.getStringId(), socketIOEvent);
  }
}
