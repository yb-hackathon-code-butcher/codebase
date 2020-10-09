package io.github.butcher.butcher.back.controller;

import io.github.butcher.butcher.back.service.GameService;
import io.github.butcher.butcher.back.service.OptionService;
import io.github.butcher.butcher.back.service.dto.GameStatsDTO;
import io.github.butcher.butcher.back.service.dto.OptionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OptionController {

  @Autowired
  private OptionService optionService;

  @GetMapping(value = "/option")
  public List<OptionDTO> getAll() {

    return optionService.getAll();
  }
}
