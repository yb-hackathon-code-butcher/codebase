package io.github.butcher.butcher.back.service;

import io.github.butcher.butcher.back.domain.Player;
import io.github.butcher.butcher.back.domain.repository.PlayerRepository;
import io.github.butcher.butcher.back.service.dto.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {

  @Autowired
  private PlayerRepository playerRepository;

  public Player createPlayer(Player player) {
    return playerRepository.save(player);
  }

  public Optional<Player> findById(Long id) {
    return playerRepository.findById(id);
  }

  public PlayerDTO update(PlayerDTO playerDTO) {
    Player player = new Player();
    // TODO Mapping
    playerRepository.save(player);

    return new PlayerDTO();
  }
}
