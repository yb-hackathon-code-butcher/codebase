package io.github.butcher.butcher.back.service;

import io.github.butcher.butcher.back.domain.Team;
import io.github.butcher.butcher.back.domain.repository.TeamRepository;
import io.github.butcher.butcher.back.service.dto.TeamDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

  private final TeamRepository teamRepository;

  public TeamService(TeamRepository teamRepository) {
    this.teamRepository = teamRepository;
  }

  public List<TeamDTO> findAll() {
    // TODO Mapping
    Iterable<Team> teams = teamRepository.findAll();
    return new ArrayList<>();
  }
}
