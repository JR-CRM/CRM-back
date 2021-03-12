package ru.ldwx.crm.service;

import org.springframework.stereotype.Service;
import ru.ldwx.crm.model.PersonDto;
import ru.ldwx.crm.repository.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {
    private PersonRepository repository;

    public PersonServiceImpl(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PersonDto> getAll() {
        return repository.getAll()
                .stream()
                .map(personEntity -> new PersonDto(personEntity.getId(),
                        personEntity.getName(),
                        personEntity.getAge()))
                .collect(Collectors.toList());
    }

    @Override
    public PersonDto getById(long id) {
        return null;
    }

    @Override
    public List<PersonDto> findByName(String name) {
        return null;
    }
}
