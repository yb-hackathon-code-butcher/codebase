package io.github.butcher.butcher.back.socket;

import static org.mockito.Mockito.verify;

import io.github.butcher.butcher.back.config.SocketIOServerConfig;
import io.github.butcher.butcher.back.config.SocketIOServerProperties;
import io.github.butcher.butcher.back.service.GameStateService;
import io.github.butcher.butcher.back.socket.event.SocketIOEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SocketIOServerProperties.class, SocketIOServerConfig.class,
    SocketIOServerOutboundEventListener.class, GameStateService.class})
public class SocketIOServerOutboundEventListenerIntegrationTest {

  @Autowired
  ApplicationEventPublisher applicationEventPublisher;

  @SpyBean
  SocketIOServerOutboundEventListener socketIOServerOutboundEventListener;

  @Test
  public void catchesSocketIOEvent() {
    TestSocketIOEvent testSocketIOEvent = new TestSocketIOEvent();
    applicationEventPublisher.publishEvent(testSocketIOEvent);
    verify(socketIOServerOutboundEventListener).broadcastEvent(testSocketIOEvent);
  }

  public class TestSocketIOEvent implements SocketIOEvent {

    @Override
    public String getStringId() {
      return "test";
    }
  }
}
