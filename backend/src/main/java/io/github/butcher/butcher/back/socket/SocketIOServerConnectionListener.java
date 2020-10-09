package io.github.butcher.butcher.back.socket;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import io.github.butcher.butcher.back.service.SocketSessionService;
import org.springframework.stereotype.Component;

@Component
public class SocketIOServerConnectionListener {

  private final SocketSessionService socketSessionService;

  public SocketIOServerConnectionListener(SocketSessionService socketSessionService,
      SocketIOServer socketIOServer) {
    this.socketSessionService = socketSessionService;

    socketIOServer.addConnectListener(new SocketIOConnectListener());
    socketIOServer.addDisconnectListener(new SocketIODisconnectListener());
  }

  private class SocketIOConnectListener implements ConnectListener {

    @Override
    public void onConnect(SocketIOClient socketIOClient) {
      socketSessionService.registerConnection(socketIOClient);
    }
  }

  private class SocketIODisconnectListener implements DisconnectListener {

    @Override
    public void onDisconnect(SocketIOClient socketIOClient) {
      socketSessionService.clientDisconnected(socketIOClient);
    }
  }
}
