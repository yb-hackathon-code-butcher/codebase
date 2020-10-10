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

  private static final Long STARTING_ZONE = Long.valueOf(3);

  private final OptionRepository optionRepository;
  private final OptionMapper optionMapper;

  public OptionService(OptionRepository optionRepository, OptionMapper optionMapper) {
    this.optionRepository = optionRepository;
    this.optionMapper = optionMapper;

  }

  @Transactional(readOnly = true)
  public List<Option> startingOptions() {
    LOGGER.info("Selecting starting options");

    return getNextOptions(STARTING_ZONE);
  }

  @Transactional(readOnly = true)
  public List<Option> getNextOptions(Long zone) {
    LOGGER.debug("Selecting next options for zone {}", zone);

    List<Option> possibleOptions = optionRepository.findAllByZone(STARTING_ZONE);
    return selectRandomFromOptions(possibleOptions);
  }

  private List<Option> selectRandomFromOptions(List<Option> possibleOptions) {
    Collections.shuffle(possibleOptions);
    List<Option> randoms = List
        .of(possibleOptions.get(0), possibleOptions.get(1), possibleOptions.get(2));

    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("Selected options are: {}", randoms);
    }

    return randoms;
  }

  public Option getById(Long optionId) {
    return optionRepository.findById(optionId)
        .orElseThrow(
            () -> new IllegalArgumentException("Cannot find option with id " + optionId));
  }

  public List<OptionDTO> getAll() {
    List<OptionDTO> optionDTOList = new ArrayList<>();
    List<Option> optionList = optionRepository.findAll();

    optionList.forEach(option -> optionDTOList.add(optionMapper.convertToDTO(option)));

    return optionDTOList;
  }

  public boolean optionIsCounteredBy(Option offensiveTeamOption, Option passiveTeamOption) {
    // TODO: Calculate if passive team is in counter options of offensive team
    return false;
  }
}
