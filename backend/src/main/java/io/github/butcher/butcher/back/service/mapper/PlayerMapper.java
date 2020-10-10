package io.github.butcher.butcher.back.service.mapper;

import io.github.butcher.butcher.back.domain.Player;
import io.github.butcher.butcher.back.domain.repository.PlayerRepository;
import io.github.butcher.butcher.back.domain.repository.TeamRepository;
import io.github.butcher.butcher.back.service.dto.PlayerDTO;
import org.springframework.stereotype.Service;

@Service
public class PlayerMapper {

  private final PlayerRepository playerRepository;
  private final TeamRepository teamRepository;

  public PlayerMapper(PlayerRepository playerRepository, TeamRepository teamRepository) {
    this.playerRepository = playerRepository;
    this.teamRepository = teamRepository;
  }

  public PlayerDTO convertToDTO(Player player) {
    PlayerDTO playerDTO = new PlayerDTO();

    playerDTO.setId(player.getId());
    playerDTO.setTeamId(player.getTeam().getId());
    playerDTO.setUsername(player.getUsername());

    return playerDTO;
  }

  public Player convert(PlayerDTO playerDTO) {

    Player player = playerRepository.findById(playerDTO.getId()).get();

    player.setTeam(teamRepository.findById(playerDTO.getTeamId()).get());
    player.setUsername(playerDTO.getUsername());

    return player;
  }
}
