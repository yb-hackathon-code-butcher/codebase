package io.github.butcher.butcher.back.service;

import io.github.butcher.butcher.back.domain.Player;
import io.github.butcher.butcher.back.domain.repository.PlayerRepository;
import io.github.butcher.butcher.back.service.dto.PlayerDTO;
import io.github.butcher.butcher.back.service.mapper.PlayerMapper;
import io.github.butcher.butcher.back.service.mapper.TeamMapper;
import org.springframework.stereotype.Service;

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
