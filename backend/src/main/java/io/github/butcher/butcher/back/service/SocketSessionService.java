package io.github.butcher.butcher.back.service;

import com.corundumstudio.socketio.SocketIOClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SocketSessionService {

  private static final Logger LOGGER = LoggerFactory.getLogger(SocketSessionService.class);

  public static final String TEAM_ROOM_PREFIX = "team-";

  public void registerConnection(SocketIOClient socketIOClient) {
    Long teamId = getTeamIdForClient(socketIOClient);
    LOGGER.debug("Client connected, joins team {}", teamId);
    socketIOClient.joinRoom(TEAM_ROOM_PREFIX + teamId);
  }

  public void clientDisconnected(SocketIOClient socketIOClient) {
    Long teamId = getTeamIdForClient(socketIOClient);
    LOGGER.debug("Client disconnected, leaves team {}", teamId);
    socketIOClient.joinRoom(TEAM_ROOM_PREFIX + teamId);
  }

  private Long getTeamIdForClient(SocketIOClient socketIOClient) {
    // TODO: This should maybe be in another service
    return null;
  }
}
