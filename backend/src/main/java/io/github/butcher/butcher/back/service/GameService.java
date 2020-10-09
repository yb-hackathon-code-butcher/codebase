package io.github.butcher.butcher.back.service;

import io.github.butcher.butcher.back.domain.Game;
import io.github.butcher.butcher.back.domain.Team;
import io.github.butcher.butcher.back.service.dto.GameStatsDTO;
import org.springframework.stereotype.Service;

@Service
public class GameService {

  public Game getNextGame() {
    // TODO: Read from DB
    return null;
  }

  public Team determineWinnerTeam() {
    // TODO
    return null;
  }

  public GameStatsDTO getGame() {
    // TODO Query and Map Attributes
    return new GameStatsDTO();
  }
}
