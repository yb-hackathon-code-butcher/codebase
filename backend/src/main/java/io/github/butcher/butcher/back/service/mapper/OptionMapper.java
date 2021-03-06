package io.github.butcher.butcher.back.service.mapper;

import io.github.butcher.butcher.back.domain.Option;
import io.github.butcher.butcher.back.domain.repository.OptionRepository;
import io.github.butcher.butcher.back.service.dto.OptionDTO;
import org.springframework.stereotype.Service;

@Service
public class OptionMapper {

  private final OptionRepository optionRepository;

  private OptionMapper(OptionRepository optionRepository) {
    this.optionRepository = optionRepository;
  }

  public OptionDTO convertToDTO(Option option) {
    OptionDTO optionDTO = new OptionDTO();

    optionDTO.setId(option.getId());
    optionDTO.setName(option.getName());
    optionDTO.setRisk(option.getRisk());

    return optionDTO;
  }

  public Option convert(OptionDTO optionDTO) {

    Option option = optionRepository.findById(optionDTO.getId()).get();

    option.setName(optionDTO.getName());
    option.setRisk(optionDTO.getRisk());

    return option;
  }
}
