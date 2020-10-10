package io.github.butcher.butcher.back.service;

import io.github.butcher.butcher.back.domain.Option;
import io.github.butcher.butcher.back.domain.repository.OptionRepository;
import io.github.butcher.butcher.back.service.dto.OptionDTO;
import io.github.butcher.butcher.back.service.mapper.OptionMapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OptionService {

  private static final Logger LOGGER = LoggerFactory.getLogger(OptionService.class);

  private static final Integer STARTING_ZONE = 3;

  private final OptionRepository optionRepository;
  private final OptionMapper optionMapper;

  public OptionService(
      OptionRepository optionRepository,
      OptionMapper optionMapper
  ) {
    this.optionRepository = optionRepository;
    this.optionMapper = optionMapper;

  }

  @Transactional(readOnly = true)
  public List<Option> startingOptions() {
    LOGGER.debug("Selecting starting options");

    List<Option> possibleOptions = optionRepository.findAllWhereZoneEquals(STARTING_ZONE);
    List<Option> randoms = selectRandomFromOptions(possibleOptions);

    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("Selected options are: {}", randoms);
    }

    return randoms;
  }

  private List<Option> selectRandomFromOptions(List<Option> possibleOptions) {
    Collections.shuffle(possibleOptions);
    return List.of(possibleOptions.get(0), possibleOptions.get(1), possibleOptions.get(2));
  }

  public List<Option> getNextOptions() {
    // TODO
    return new ArrayList();
  }

  public List<OptionDTO> getAll() {

    List<OptionDTO> optionDTOList = new ArrayList<>();
    List<Option> optionList = optionRepository.findAll();

    optionList.forEach(option -> {
      optionDTOList.add(optionMapper.convertToDTO(option));
    });

    return optionDTOList;
  }
}
