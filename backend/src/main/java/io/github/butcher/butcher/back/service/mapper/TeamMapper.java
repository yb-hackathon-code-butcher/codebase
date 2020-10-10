package io.github.butcher.butcher.back.service.mapper;

import io.github.butcher.butcher.back.domain.Team;
import io.github.butcher.butcher.back.domain.repository.TeamRepository;
import io.github.butcher.butcher.back.service.dto.TeamDTO;
import org.springframework.stereotype.Service;

@Service
public class TeamMapper {

  private final TeamRepository teamRepository;

  public TeamMapper(TeamRepository teamRepository) {
    this.teamRepository = teamRepository;
  }

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
