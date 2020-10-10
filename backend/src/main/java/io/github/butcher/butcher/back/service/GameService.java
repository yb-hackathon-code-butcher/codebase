package io.github.butcher.butcher.back.service;

import io.github.butcher.butcher.back.domain.Game;
import io.github.butcher.butcher.back.domain.Team;
import io.github.butcher.butcher.back.domain.repository.GameRepository;
import io.github.butcher.butcher.back.service.dto.GameStatsDTO;
import io.github.butcher.butcher.back.service.mapper.GameStatsMapper;
import org.springframework.stereotype.Service;

@Service
public class GameService {

  private final GameStatsMapper gameStatsMapper;

  private final GameRepository gameRepository;

  public GameService(GameRepository gameRepository, GameStatsMapper gameStatsMapper) {
    this.gameRepository = gameRepository;
    this.gameStatsMapper = gameStatsMapper;
  }

  public Game getNextGame() {
    // TODO: Read from DB
    return null;
  }

  public Team determineWinnerTeam() {
    Game currentGame = getCurrentGame();

    if (currentGame.getTeam1Score() > currentGame.getTeam2Score()) {
      return currentGame.getTeam1();
    }

    return currentGame.getTeam2();
  }

  public Game getCurrentGame() {
    // TODO: Find current game
    return gameRepository.findAll().get(0);
  }

  public GameStatsDTO getGame() {
    return gameStatsMapper.convertToDTO(getCurrentGame());
  }
}
