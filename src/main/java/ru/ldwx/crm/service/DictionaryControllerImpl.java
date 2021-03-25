package ru.ldwx.crm.service;

import org.springframework.stereotype.Service;
import ru.ldwx.crm.model.StatusDto;
import ru.ldwx.crm.model.StatusEntity;
import ru.ldwx.crm.repository.DictionaryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DictionaryControllerImpl implements DictionaryController {

    private DictionaryRepository dictionaryRepository;

    public DictionaryControllerImpl(DictionaryRepository dictionaryRepository) {
        this.dictionaryRepository = dictionaryRepository;
    }

    @Override
    public List<StatusDto> getAllStatuses() {
        return dictionaryRepository.getAllStatuses()
                .stream().map(status -> new StatusDto(
                        status.getCode(), status.getName()
                )).collect(Collectors.toList());
    }

    @Override
    public List<StatusDto> getAllStatusFilters() {
        return dictionaryRepository.getAllStatuses()
                .stream().map(status -> new StatusDto(
                        status.getCode(), status.getName()
                )).collect(Collectors.toList());
    }
}
