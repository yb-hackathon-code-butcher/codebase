package io.github.butcher.butcher.back.service;

import com.corundumstudio.socketio.SocketIOClient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class SocketSessionService {

  private static final Map<Long, List<SocketIOClient>> SOCKET_IO_CONNECTIONS_PER_TEAM = new HashMap<>();

  public void registerConnection(SocketIOClient socketIOClient) {
    SOCKET_IO_CONNECTIONS_PER_TEAM.get(getTeamIdForClient(socketIOClient))
        .add(socketIOClient);
  }

  public void clientDisconnected(SocketIOClient socketIOClient) {
    SOCKET_IO_CONNECTIONS_PER_TEAM.get(getTeamIdForClient(socketIOClient))
        .remove(socketIOClient);
  }

  private Long getTeamIdForClient(SocketIOClient socketIOClient) {
    // TODO: This should maybe be in another service
    return null;
  }
}
