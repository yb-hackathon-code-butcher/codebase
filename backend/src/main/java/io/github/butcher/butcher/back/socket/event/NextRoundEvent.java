package io.github.butcher.butcher.back.socket.event;

import io.github.butcher.butcher.back.domain.Option;
import io.github.butcher.butcher.back.socket.GameEvent;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NextRoundEvent implements SocketIOEvent {

  private Long[] optionIds;
  private LocalDateTime endTime;

  private Long teamId;

  public NextRoundEvent(List<Option> options, LocalDateTime endTime, Long teamId) {
    this.optionIds = options.stream()
        .map(Option::getId)
        .collect(Collectors.toList())
        .toArray(new Long[options.size()]);
    this.endTime = endTime;
    this.teamId = teamId;
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

  @Override
  public Long getTeamId() {
    return teamId;
  }

  @Override
  public String toString() {
    return "NextRoundEvent{" +
        "optionIds=" + Arrays.toString(optionIds) +
        ", endTime=" + endTime +
        '}';
  }
}
