package io.github.butcher.butcher.back.controller;

import io.github.butcher.butcher.back.service.GameService;
import io.github.butcher.butcher.back.service.dto.GameStatsDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

  private final GameService gameService;

  public GameController(GameService gameService) {
    this.gameService = gameService;
  }

  @GetMapping(value = "/gameObject")
  public GameStatsDTO getGame() {
    return gameService.getGame();
  }
}
