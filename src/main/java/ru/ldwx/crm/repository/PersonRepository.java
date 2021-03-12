package ru.ldwx.crm.repository;

import ru.ldwx.crm.model.PersonEntity;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {
    List<PersonEntity> getAll();
    Optional<PersonEntity> getById(long id);
    List<PersonEntity> findByName(String name);
}
