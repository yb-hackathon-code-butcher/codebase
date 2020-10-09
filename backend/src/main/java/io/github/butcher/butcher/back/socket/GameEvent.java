package io.github.butcher.butcher.back.socket;

public enum GameEvent {

  VOTE("vote"),
  JOIN("join"),

  GAME_STARTS("game_starts"),
  NEXT_ROUND("next_round"),
  VOTE_UPDATE("vote_update"),
  ROUND_ENDED("round_ended"),
  GAME_ENDED("game_ended");

  private final String stringId;

  private GameEvent(String stringId) {
    this.stringId = stringId;
  }

  public String getStringId() {
    return stringId;
  }
}
