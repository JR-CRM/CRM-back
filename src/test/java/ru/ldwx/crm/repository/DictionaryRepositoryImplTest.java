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
import ru.ldwx.crm.data.StatusTestData;
import ru.ldwx.crm.model.StatusEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@JdbcTest
@TestPropertySource("classpath:sql-query.properties")
@Sql(scripts = {"classpath:dictionary_schema.sql", "classpath:dictionary_data.sql"})
class DictionaryRepositoryImplTest {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    private DictionaryRepository repository;

    @Value("${get.all.statuses}")
    private String getAllStatuses;

    @BeforeEach
    void init() {
        repository = new DictionaryRepositoryImpl(jdbcTemplate);
        ReflectionTestUtils.setField(repository, "getAllStatuses", getAllStatuses);
    }

    @Test
    void getAllStatusesShouldWork() {
        List<StatusEntity> allStatuses = repository.getAllStatuses();
        assertEquals(StatusTestData.getAllStatusEntities(), allStatuses);
        assertEquals(4, allStatuses.size());
    }

}