package ru.ldwx.crm.service;

import ru.ldwx.crm.model.PersonDto;

import java.util.List;

public interface PersonService {
    List<PersonDto> getAll();

    PersonDto getById(long id);

    List<PersonDto> findByName(String name);
}
