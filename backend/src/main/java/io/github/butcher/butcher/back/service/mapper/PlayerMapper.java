package io.github.butcher.butcher.back.service.mapper;

import io.github.butcher.butcher.back.domain.Option;
import io.github.butcher.butcher.back.domain.Player;
import io.github.butcher.butcher.back.domain.repository.PlayerRepository;
import io.github.butcher.butcher.back.domain.repository.TeamRepository;
import io.github.butcher.butcher.back.service.dto.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerMapper {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

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
