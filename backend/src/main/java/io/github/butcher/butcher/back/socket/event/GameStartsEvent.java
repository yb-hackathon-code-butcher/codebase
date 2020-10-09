package io.github.butcher.butcher.back.socket.event;

import io.github.butcher.butcher.back.domain.Game;
import io.github.butcher.butcher.back.socket.GameEvent;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

public class GameStartsEvent implements SocketIOEvent {

  private Long startTeamId;
  private LocalDateTime endTime;

  public GameStartsEvent(Game game) {
    this.startTeamId = randomOfTwo(game.getTeam1Id(), game.getTeam2Id());
    this.endTime = game.getStartTime();
  }

  private Long randomOfTwo(Long team1Id, Long team2Id) {
    return new Long[]{team1Id, team2Id}[ThreadLocalRandom.current().nextInt(0, 2)];
  }

  public Long getStartTeamId() {
    return startTeamId;
  }

  public void setStartTeamId(Long startTeamId) {
    this.startTeamId = startTeamId;
  }

  public LocalDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
  }

  @Override
  public String getStringId() {
    return GameEvent.GAME_STARTS.getStringId();
  }
}
