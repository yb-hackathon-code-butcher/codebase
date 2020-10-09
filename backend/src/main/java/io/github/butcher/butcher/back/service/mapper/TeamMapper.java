package io.github.butcher.butcher.back.service.mapper;

import io.github.butcher.butcher.back.domain.Player;
import io.github.butcher.butcher.back.domain.Team;
import io.github.butcher.butcher.back.domain.repository.PlayerRepository;
import io.github.butcher.butcher.back.domain.repository.TeamRepository;
import io.github.butcher.butcher.back.service.dto.PlayerDTO;
import io.github.butcher.butcher.back.service.dto.TeamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamMapper {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    public TeamDTO convertToDTO(Team team) {
        TeamDTO teamDTO = new TeamDTO();

        teamDTO.setId(team.getId());
        teamDTO.setName(team.getName());

        return teamDTO;
    }

    public Team convert(TeamDTO teamDTO) {

        Team team = teamRepository.findById(teamDTO.getId()).get();

        team.setName(teamDTO.getName());
        
        return team;
    }


}
