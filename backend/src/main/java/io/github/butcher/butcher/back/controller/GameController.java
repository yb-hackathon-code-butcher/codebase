package io.github.butcher.butcher.back.controller;

import io.github.butcher.butcher.back.domain.Player;
import io.github.butcher.butcher.back.service.GameService;
import io.github.butcher.butcher.back.service.PlayerService;
import io.github.butcher.butcher.back.service.dto.GameStatsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

  @Autowired
  private GameService gameService;

  @GetMapping(value = "/game")
  public GameStatsDTO getGame() {
    return gameService.getGame();
  }
}
