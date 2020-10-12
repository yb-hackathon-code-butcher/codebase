package io.github.butcher.butcher.back.controller;

import io.github.butcher.butcher.back.service.TeamService;
import io.github.butcher.butcher.back.service.dto.TeamDTO;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TeamController {

  private final TeamService teamService;

  public TeamController(TeamService teamService) {
    this.teamService = teamService;
  }

  @GetMapping(value = "/teams")
  public List<TeamDTO> getAll() {

    return teamService.findAll();
  }
}
