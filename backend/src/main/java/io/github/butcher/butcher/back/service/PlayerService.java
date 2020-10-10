package io.github.butcher.butcher.back.service;

import io.github.butcher.butcher.back.domain.Player;
import io.github.butcher.butcher.back.domain.repository.PlayerRepository;
import io.github.butcher.butcher.back.service.dto.PlayerDTO;
import io.github.butcher.butcher.back.service.mapper.PlayerMapper;
import io.github.butcher.butcher.back.service.mapper.TeamMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {

  private final PlayerRepository playerRepository;
  private final PlayerMapper playerMapper;
  private final TeamService teamService;
  private final TeamMapper teamMapper;


  public PlayerService(
      PlayerRepository playerRepository,
      PlayerMapper playerMapper,
      TeamService teamService,
      TeamMapper teamMapper
  ) {
    this.playerRepository = playerRepository;
    this.playerMapper = playerMapper;
    this.teamService = teamService;
    this.teamMapper = teamMapper;
  }


  public PlayerDTO createPlayer(String uid) {
    Optional<Player> player = playerRepository.findByUid(uid);

    if(!player.isPresent()) {
      Player newPlayer = new Player();
      newPlayer.setTeam(teamMapper.convert(teamService.findById(1L)));
      newPlayer.setUid(uid);
      newPlayer.setUsername("geyoungboyst");
      playerRepository.save(newPlayer);

      return playerMapper.convertToDTO(newPlayer);
    }
    return playerMapper.convertToDTO(player.get());
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
