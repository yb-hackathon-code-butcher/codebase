package io.github.butcher.butcher.back.controller;

import io.github.butcher.butcher.back.service.PlayerService;
import io.github.butcher.butcher.back.service.dto.PlayerDTO;
import io.github.butcher.butcher.back.service.dto.UIDDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PlayerController {

  private final PlayerService playerService;

  public PlayerController(PlayerService playerService) {
    this.playerService = playerService;
  }

  @PostMapping(value = "/players")
  public PlayerDTO createPlayer(@RequestBody UIDDTO uiddto) {
    return playerService.createPlayer(uiddto.getUid());
  }

  @PutMapping(value = "/player")
  public PlayerDTO updatePlayer(@RequestBody PlayerDTO playerDTO) {
    return playerService.update(playerDTO);
  }

  @GetMapping(value = "/player/{id}")
  public PlayerDTO findPlayer(@PathVariable Long id) {
    return playerService.findById(id);
  }

  @PostMapping(value = "player/{id}/select-team")
  public PlayerDTO selectTeam(@PathVariable Long id, @RequestBody Long teamId) {
    return playerService.selectTeam(id, teamId);
  }
}
