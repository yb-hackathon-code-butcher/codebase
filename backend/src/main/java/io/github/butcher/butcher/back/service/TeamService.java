package io.github.butcher.butcher.back.service;

import io.github.butcher.butcher.back.domain.Team;
import io.github.butcher.butcher.back.domain.repository.TeamRepository;
import io.github.butcher.butcher.back.service.dto.TeamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<TeamDTO> findAll() {

        // TODO Mapping

        Iterable<Team> teams = teamRepository.findAll();

        return new ArrayList<>();
    }
}
