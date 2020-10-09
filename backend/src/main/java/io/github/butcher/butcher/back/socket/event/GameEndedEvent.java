package io.github.butcher.butcher.back.socket.event;

import io.github.butcher.butcher.back.domain.Team;
import io.github.butcher.butcher.back.socket.GameEvent;

public class GameEndedEvent implements SocketIOEvent {

  private Long winnerTeamId;

  public GameEndedEvent(Team winnerTeam) {
    this.winnerTeamId = winnerTeam.getId();
  }

  public Long getWinnerTeamId() {
    return winnerTeamId;
  }

  public void setWinnerTeamId(Long winnerTeamId) {
    this.winnerTeamId = winnerTeamId;
  }

  @Override
  public String getStringId() {
    return GameEvent.GAME_ENDED.getStringId();
  }
}
