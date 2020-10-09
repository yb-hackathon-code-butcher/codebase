package io.github.butcher.butcher.back.socket;

import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;

public abstract class AbstractSocketIOEventListener<T> implements DataListener<T> {

  public AbstractSocketIOEventListener(SocketIOServer socketIOServer) {
    registerListener(socketIOServer);
  }

  protected abstract void registerListener(SocketIOServer socketIOServer);
}
