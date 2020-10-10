package io.github.butcher.butcher.back.socket;

import com.corundumstudio.socketio.SocketIOServer;
import io.github.butcher.butcher.back.service.GameStateService;
import io.github.butcher.butcher.back.service.SocketSessionService;
import io.github.butcher.butcher.back.socket.event.SocketIOEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SocketIOServerOutboundEventListener {

  private static final Logger LOGGER = LoggerFactory
      .getLogger(SocketIOServerOutboundEventListener.class);

  private final SocketIOServer socketIOServer;
  private final GameStateService gameStateService;

  public SocketIOServerOutboundEventListener(SocketIOServer socketIOServer,
      GameStateService gameStateService) {
    this.socketIOServer = socketIOServer;
    this.gameStateService = gameStateService;
  }

  @EventListener
  public void broadcastEvent(SocketIOEvent socketIOEvent) {
    if (socketIOEvent.getTeamId() != null) {
      broadcastTeamWise(socketIOEvent);
    } else {
      broadcast(socketIOEvent);
    }
  }

  private void broadcastTeamWise(SocketIOEvent socketIOEvent) {
    LOGGER.info("Broadcasting event {} team wise", socketIOEvent);

    socketIOServer
        .getRoomOperations(SocketSessionService.TEAM_ROOM_PREFIX + socketIOEvent.getTeamId())
        .sendEvent(socketIOEvent.getStringId(), socketIOEvent);
  }

  private void broadcast(SocketIOEvent socketIOEvent) {
    LOGGER.info("Broadcasting event {}", socketIOEvent);

    socketIOServer.getBroadcastOperations().sendEvent(socketIOEvent.getStringId(), socketIOEvent);
  }
}
