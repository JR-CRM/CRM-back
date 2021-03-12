package ru.ldwx.crm.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.util.ReflectionTestUtils;
import ru.ldwx.crm.data.PersonTestData;
import ru.ldwx.crm.model.PersonEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@JdbcTest
@TestPropertySource("classpath:sql-query.properties")
@Sql(scripts = {"classpath:person_schema.sql", "classpath:person_data.sql"})
class PersonRepositoryImplTest {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    private PersonRepository repository;

    @Value("${select.all.persons}")
    private String selectAllPersons;

    @BeforeEach
    void init() {
        repository = new PersonRepositoryImpl(jdbcTemplate);
        ReflectionTestUtils.setField(repository, "selectAllPersons", selectAllPersons);
    }

    @Test
    void getAllShouldWork() {
        List<PersonEntity> allPersons = repository.getAll();
        assertEquals(3, allPersons.size());
        assertEquals(PersonTestData.getAllPersonEntities(), allPersons);
    }

    @Test
    void getByIdShouldWork() {
    }

    @Test
    void findByNameShouldWork() {
    }
}