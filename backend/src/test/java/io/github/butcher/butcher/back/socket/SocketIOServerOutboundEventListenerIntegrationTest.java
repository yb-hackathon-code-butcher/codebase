package io.github.butcher.butcher.back.socket;

import static org.mockito.Mockito.verify;

import io.github.butcher.butcher.back.AbstractApplicationContextAwareTest;
import io.github.butcher.butcher.back.socket.event.SocketIOEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.ApplicationEventPublisher;

class SocketIOServerOutboundEventListenerIntegrationTest extends
    AbstractApplicationContextAwareTest {

  @Autowired
  private ApplicationEventPublisher applicationEventPublisher;

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
