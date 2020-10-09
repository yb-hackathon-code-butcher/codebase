package io.github.butcher.butcher.back.service;

import io.github.butcher.butcher.back.domain.Player;
import io.github.butcher.butcher.back.domain.repository.PlayerRepository;
import io.github.butcher.butcher.back.service.dto.PlayerDTO;
import io.github.butcher.butcher.back.service.mapper.PlayerMapper;
import io.github.butcher.butcher.back.service.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

  @Autowired
  private PlayerRepository playerRepository;

  @Autowired
  private PlayerMapper playerMapper;

  @Autowired
  private TeamService teamService;

  @Autowired
  private TeamMapper teamMapper;

  public Player createPlayer(Player player) {
    return playerRepository.save(player);
  }

  public PlayerDTO findById(Long id) {

    PlayerDTO playerDTO = playerMapper.convertToDTO(playerRepository.findById(id).get());

    return playerDTO;
  }

  public PlayerDTO update(PlayerDTO playerDTO) {

    Player player = playerMapper.convert(playerDTO);
    player = playerRepository.save(player);

    PlayerDTO updatedPlayerDTO = playerMapper.convertToDTO(player);

    return updatedPlayerDTO;
  }

  public PlayerDTO selectTeam(Long playerId, Long teamId) {
    Player player = playerRepository.findById(playerId).get();

    player.setTeam(teamMapper.convert(teamService.findById(teamId)));
    player = playerRepository.save(player);

    return playerMapper.convertToDTO(player);
  }
}
