package ru.ldwx.crm.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ldwx.crm.data.PersonTestData;
import ru.ldwx.crm.model.PersonDto;
import ru.ldwx.crm.repository.PersonRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class PersonServiceImplTest {
    private PersonRepository repository = mock(PersonRepository.class);
    private PersonService service;

    @BeforeEach
    void initMocks() {
        given(repository.getAll()).willReturn(PersonTestData.getAllPersonEntities());
        service = new PersonServiceImpl(repository);
    }

    @Test
    void getAllShouldWork() {
        List<PersonDto> allPersons = service.getAll();
        assertEquals(3, allPersons.size());
        assertEquals(PersonTestData.getAllPersonDtos(), allPersons);
    }

    @Test
    void getByIdShouldWork() {
    }

    @Test
    void findByNameShouldWork() {
    }
}