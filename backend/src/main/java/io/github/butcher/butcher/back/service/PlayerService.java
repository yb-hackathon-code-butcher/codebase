package io.github.butcher.butcher.back.service;

import io.github.butcher.butcher.back.domain.Player;
import io.github.butcher.butcher.back.domain.repository.PlayerRepository;
import io.github.butcher.butcher.back.service.dto.PlayerDTO;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

  private final PlayerRepository playerRepository;

  public PlayerService(PlayerRepository playerRepository) {
    this.playerRepository = playerRepository;
  }

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
