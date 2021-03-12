package ru.ldwx.crm.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.ldwx.crm.model.PersonEntity;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
    @Value("${select.all.persons}")
    private String selectAllPersons;
    private NamedParameterJdbcTemplate jdbcTemplate;

    public PersonRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<PersonEntity> getAll() {
        return jdbcTemplate.query(selectAllPersons,
                (resultSet, i) -> new PersonEntity(resultSet.getLong("ID"),
                        resultSet.getString("NAME"),
                        resultSet.getInt("AGE")));
    }

    @Override
    public Optional<PersonEntity> getById(long id) {
        return Optional.empty();
    }

    @Override
    public List<PersonEntity> findByName(String name) {
        return List.of();
    }
}
