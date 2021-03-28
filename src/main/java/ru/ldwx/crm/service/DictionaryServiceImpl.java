package ru.ldwx.crm.service;

import org.springframework.stereotype.Service;
import ru.ldwx.crm.model.StatusDto;
import ru.ldwx.crm.repository.DictionaryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    private DictionaryRepository dictionaryRepository;

    public DictionaryServiceImpl(DictionaryRepository dictionaryRepository) {
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
        List<StatusDto> allStatusesFilters = new ArrayList<>();
        allStatusesFilters.add(new StatusDto("All", "Statuses"));
        allStatusesFilters.addAll(dictionaryRepository.getAllStatuses()
                .stream().map(status -> new StatusDto(
                        status.getCode(), status.getName()
                )).collect(Collectors.toList()));
        return allStatusesFilters;
    }
}
