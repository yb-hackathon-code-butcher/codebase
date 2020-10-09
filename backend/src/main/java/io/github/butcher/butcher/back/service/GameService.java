package io.github.butcher.butcher.back.service;

import io.github.butcher.butcher.back.domain.Game;
import io.github.butcher.butcher.back.domain.repository.GameRepository;
import io.github.butcher.butcher.back.service.dto.GameStatsDTO;
import io.github.butcher.butcher.back.service.mapper.GameMapper;
import io.github.butcher.butcher.back.service.mapper.GameStatsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

  @Autowired
  private GameStatsMapper gameStatsMapper;

  @Autowired
  private GameRepository gameRepository;

  public Game getNextGame() {
    // TODO: Read from DB
    return null;
  }

  public GameStatsDTO getGame() {

    GameStatsDTO gameStatsDTO = gameStatsMapper.convertToDTO(gameRepository.findFirst());

    return new GameStatsDTO();
  }
}
