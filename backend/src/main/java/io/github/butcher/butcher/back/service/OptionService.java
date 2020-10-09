package io.github.butcher.butcher.back.service;

import io.github.butcher.butcher.back.domain.Option;
import io.github.butcher.butcher.back.domain.repository.OptionRepository;
import io.github.butcher.butcher.back.service.dto.OptionDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OptionService {

  private final OptionRepository optionRepository;

  public OptionService(OptionRepository optionRepository) {
    this.optionRepository = optionRepository;
  }

  public List<Option> startingOptions() {
    // TODO
    return new ArrayList();
  }

  public List<Option> getNextOptions() {
    // TODO
    return new ArrayList();
  }


  public List<OptionDTO> getAll() {
    Iterable<Option> optionList = optionRepository.findAll();
    // TODO Mappings
    return new ArrayList<>();
  }
}
