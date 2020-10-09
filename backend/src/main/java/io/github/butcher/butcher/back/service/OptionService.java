package io.github.butcher.butcher.back.service;

import io.github.butcher.butcher.back.domain.Option;
import io.github.butcher.butcher.back.domain.repository.OptionRepository;
import io.github.butcher.butcher.back.service.dto.OptionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OptionService {

    @Autowired
    private OptionRepository optionRepository;

    public List<OptionDTO> getAll() {

        Iterable<Option> optionList = optionRepository.findAll();
        // TODO Mappings
        return new ArrayList<>();
    }
}
