package io.github.butcher.butcher.back.service;

import io.github.butcher.butcher.back.domain.Option;
import io.github.butcher.butcher.back.domain.Team;
import io.github.butcher.butcher.back.domain.repository.TeamRepository;
import io.github.butcher.butcher.back.service.dto.OptionDTO;
import io.github.butcher.butcher.back.service.dto.TeamDTO;
import io.github.butcher.butcher.back.service.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamMapper teamMapper;

    public List<TeamDTO> findAll() {

        List<TeamDTO> teamDTOList = new ArrayList<>();
        List<Team> teamList = teamRepository.findAll();

        teamList.forEach(team -> {
            teamDTOList.add(teamMapper.convertToDTO(team));
        });

        return new ArrayList<>();
    }

    public TeamDTO findById(Long teamId) {
        return teamMapper.convertToDTO(teamRepository.findById(teamId).get());
    }
}
