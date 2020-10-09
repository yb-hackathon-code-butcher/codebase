package io.github.butcher.butcher.back.socket.event;

public class GameEndedEvent {

  private Long winnerTeamId;

  public Long getWinnerTeamId() {
    return winnerTeamId;
  }

  public void setWinnerTeamId(Long winnerTeamId) {
    this.winnerTeamId = winnerTeamId;
  }
}
