package io.github.butcher.butcher.back.socket.event;

import java.util.Map;

public class VoteUpdateEvent {

  private Map<String, Long[]> options;

  public Map<String, Long[]> getOptions() {
    return options;
  }

  public void setOptions(Map<String, Long[]> options) {
    this.options = options;
  }
}
