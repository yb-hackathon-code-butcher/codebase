package io.github.butcher.butcher.back.controller;

import io.github.butcher.butcher.back.service.TeamService;
import io.github.butcher.butcher.back.service.dto.TeamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TeamController {

  @Autowired
  private TeamService teamService;

  @GetMapping(value = "/teams")
  public List<TeamDTO> getAll() {

    return teamService.findAll();
  }
}
