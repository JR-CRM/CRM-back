package ru.ldwx.crm.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.ldwx.crm.data.PersonTestData;
import ru.ldwx.crm.data.StatusTestData;
import ru.ldwx.crm.repository.DictionaryRepository;

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
    }

    @Test
    void getAllStatusFilters() {
    }
}