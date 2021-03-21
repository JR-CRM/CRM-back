package ru.ldwx.crm.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.ldwx.crm.model.CustomerEntity;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{

    @Value("${select.customer.by.id}")
    private String getById;
    @Value("${select.customer.by.email}")
    private String getByEmail;
    @Value("${select.customer.by.name}")
    private String getByName;
    @Value("${select.customer.by.phone}")
    private String getByPhone;

    private NamedParameterJdbcTemplate jdbcTemplate;

    public CustomerRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<CustomerEntity> get(int id) {
        return jdbcTemplate.queryForObject(getById,
                new MapSqlParameterSource("id", id),
                (rs, rowNum) -> Optional.of(new CustomerEntity(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("phoneNumber"),
                        rs.getString("email")
                )));
    }

    @Override
    public Optional<CustomerEntity> getByEmail(String email) {
        return jdbcTemplate.queryForObject(getByEmail,
                new MapSqlParameterSource("email", email),
                (rs, rowNum) -> Optional.of(new CustomerEntity(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("phoneNumber"),
                        rs.getString("email")
                )));
    }

    @Override
    public List<CustomerEntity> findByName(String name) {
        return jdbcTemplate.query(getByName,
                new MapSqlParameterSource("name", name),
                new BeanPropertyRowMapper<>(CustomerEntity.class)
        );
    }

    @Override
    public List<CustomerEntity> findByPhone(String phone) {
        return jdbcTemplate.query(getByPhone,
                new MapSqlParameterSource("phone", phone),
                new BeanPropertyRowMapper<>(CustomerEntity.class)
        );
    }
}
