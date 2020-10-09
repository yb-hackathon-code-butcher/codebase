package io.github.butcher.butcher.back.controller;

import io.github.butcher.butcher.back.domain.Player;
import io.github.butcher.butcher.back.service.PlayerService;
import io.github.butcher.butcher.back.service.dto.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PlayerController {

  @Autowired
  private PlayerService playerService;

  @PostMapping(value = "/players")
  public Player createPlayer() {
    Player player = new Player();
    player.setUsername("test");
    return playerService.createPlayer(player);
  }

  @PutMapping(value = "/player")
  public PlayerDTO updatePlayer(@RequestBody PlayerDTO playerDTO) {
    return playerService.update(playerDTO);
  }

  @GetMapping(value = "/player/{id}")
  public Optional<Player> getPlayer(@PathVariable Long id) {
    return playerService.findById(id);
  }
}
