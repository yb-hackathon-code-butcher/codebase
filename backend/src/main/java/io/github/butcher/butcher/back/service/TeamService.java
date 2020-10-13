package io.github.butcher.butcher.back.service;

import io.github.butcher.butcher.back.domain.Team;
import io.github.butcher.butcher.back.domain.repository.TeamRepository;
import io.github.butcher.butcher.back.service.dto.TeamDTO;
import io.github.butcher.butcher.back.service.mapper.TeamMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

  private final TeamRepository teamRepository;
  private final TeamMapper teamMapper;

  public TeamService(
      TeamRepository teamRepository,
      TeamMapper teamMapper
  ) {
    this.teamRepository = teamRepository;
    this.teamMapper = teamMapper;
  }


  public List<TeamDTO> findAll() {

    List<TeamDTO> teamDTOList = new ArrayList<>();
    List<Team> teamList = teamRepository.findAll();

    teamList.forEach(team -> {
      teamDTOList.add(teamMapper.convertToDTO(team));
    });

    return teamDTOList;
  }

  public TeamDTO findById(Long teamId) {
    return teamMapper.convertToDTO(teamRepository.findById(teamId).get());
  }

  public List<Team> createInstantNewGame() {
    List<Team> teams = new ArrayList<>();
    teams.add(teamRepository.findById(1L).get());
    teams.add(teamRepository.findById(2L).get());

    return teams;
  }
}
