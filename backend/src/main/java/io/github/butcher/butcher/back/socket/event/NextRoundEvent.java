package io.github.butcher.butcher.back.socket.event;

import io.github.butcher.butcher.back.domain.Option;
import io.github.butcher.butcher.back.socket.GameEvent;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class NextRoundEvent implements SocketIOEvent {

  private Long[] optionIds;
  private LocalDateTime endTime;

  public NextRoundEvent(List<Option> options, int roundDurationSeconds) {
    this.optionIds = options.stream()
        .map(Option::getId)
        .collect(Collectors.toList())
        .toArray(new Long[options.size()]);
    this.endTime = LocalDateTime.now().plus(roundDurationSeconds, ChronoUnit.SECONDS);
  }

  public Long[] getOptionIds() {
    return optionIds;
  }

  public void setOptionIds(Long[] optionIds) {
    this.optionIds = optionIds;
  }

  public LocalDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
  }

  @Override
  public String getStringId() {
    return GameEvent.NEXT_ROUND.getStringId();
  }
}
