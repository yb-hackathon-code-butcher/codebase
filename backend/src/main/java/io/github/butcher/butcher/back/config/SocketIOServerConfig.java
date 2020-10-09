package io.github.butcher.butcher.back.config;

import com.corundumstudio.socketio.SocketIOServer;
import javax.annotation.PreDestroy;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * Socket.io implementation based on: https://github.com/mrniko/netty-socketio.
 * A working example: https://github.com/mrniko/netty-socketio-demo.
 */
@Configuration
public class SocketIOServerConfig {

  private final SocketIOServerProperties socketIOServerProperties;

  public SocketIOServerConfig(SocketIOServerProperties socketIOServerProperties) {
    this.socketIOServerProperties = socketIOServerProperties;
  }

  @Bean
  public SocketIOServer socketIOServer() {
    com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
    config.setHostname(socketIOServerProperties.getHostname());
    config.setPort(socketIOServerProperties.getPort());

    return new SocketIOServer(config);
  }

  @EventListener
  public void startSocketIOServer(ApplicationReadyEvent applicationReadyEvent) {
    socketIOServer().start();
  }

  @PreDestroy
  public void shutDownSocketIOServer() {
    socketIOServer().stop();
  }
}
