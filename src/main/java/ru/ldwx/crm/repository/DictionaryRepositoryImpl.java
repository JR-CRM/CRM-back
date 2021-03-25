package ru.ldwx.crm.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.ldwx.crm.model.StatusEntity;

import java.util.List;

@Repository
public class DictionaryRepositoryImpl implements DictionaryRepository{

    @Value("${get.all.statuses}")
    private String getAllStatuses;

    private NamedParameterJdbcTemplate jdbcTemplate;

    public DictionaryRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<StatusEntity> getAllStatuses() {
        return jdbcTemplate.query(getAllStatuses,
                (rs, rowNum) -> new StatusEntity(
                        rs.getString("code"),
                        rs.getString("name")
                ));
    }
}
