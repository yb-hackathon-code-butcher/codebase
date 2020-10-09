package io.github.butcher.butcher.back.service;

import io.github.butcher.butcher.back.domain.Option;
import io.github.butcher.butcher.back.domain.repository.OptionRepository;
import io.github.butcher.butcher.back.service.dto.OptionDTO;
import io.github.butcher.butcher.back.service.mapper.OptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OptionService {

    private final OptionRepository optionRepository;
    private final OptionMapper optionMapper;

    public OptionService(
            OptionRepository optionRepository,
            OptionMapper optionMapper
    ) {
        this.optionRepository = optionRepository;
        this.optionMapper = optionMapper;

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

        List<OptionDTO> optionDTOList = new ArrayList<>();
        List<Option> optionList = optionRepository.findAll();

        optionList.forEach(option -> {
            optionDTOList.add(optionMapper.convertToDTO(option));
        });

        return optionDTOList;
    }
}
