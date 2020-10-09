package io.github.butcher.butcher.back.service;

import io.github.butcher.butcher.back.domain.Game;
import org.springframework.stereotype.Service;

@Service
public class GameService {

  public Game getNextGame() {
    // TODO: Read from DB
    return new Game();
  }
}
