package io.github.butcher.butcher.back.socket;

import com.corundumstudio.socketio.SocketIOServer;
import io.github.butcher.butcher.back.service.GameStateService;
import io.github.butcher.butcher.back.service.SocketSessionService;
import io.github.butcher.butcher.back.socket.event.SocketIOEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SocketIOServerOutboundEventListener {

  private final SocketIOServer socketIOServer;
  private final GameStateService gameStateService;

  public SocketIOServerOutboundEventListener(SocketIOServer socketIOServer,
      GameStateService gameStateService) {
    this.socketIOServer = socketIOServer;
    this.gameStateService = gameStateService;
  }

  @EventListener
  public void broadcastEvent(SocketIOEvent socketIOEvent) {
    gameStateService.getActiveTeamIds().forEach(activeTeamId -> {
      socketIOServer.getRoomOperations(SocketSessionService.TEAM_ROOM_PREFIX + activeTeamId)
          .sendEvent(socketIOEvent.getStringId(), socketIOEvent);
    });
  }
}
