package io.github.butcher.butcher.back.controller;

import io.github.butcher.butcher.back.service.OptionService;
import io.github.butcher.butcher.back.service.dto.OptionDTO;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OptionController {

  private final OptionService optionService;

  public OptionController(OptionService optionService) {
    this.optionService = optionService;
  }

  @GetMapping(value = "/option")
  public List<OptionDTO> getAll() {
    return optionService.getAll();
  }
}
