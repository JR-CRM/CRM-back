package ru.ldwx.crm.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.ldwx.crm.data.StatusTestData;
import ru.ldwx.crm.model.StatusDto;
import ru.ldwx.crm.repository.DictionaryRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class DictionaryControllerImplTest {

    private DictionaryController controller;

    private DictionaryRepository repository;

    @BeforeEach
    void init() {
        repository = mock(DictionaryRepository.class);
        controller = new DictionaryControllerImpl(repository);
        given(repository.getAllStatuses()).willReturn(StatusTestData.getAllStatusEntities());
    }

    @Test
    void getAllStatuses() {
        List<StatusDto> allStatuses = controller.getAllStatuses();
        assertEquals(StatusTestData.getAllStatusDtos(), allStatuses);
        assertEquals(3, allStatuses.size());
    }

    @Test
    void getAllStatusFilters() {
    }
}