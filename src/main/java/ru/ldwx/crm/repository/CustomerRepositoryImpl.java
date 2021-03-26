package ru.ldwx.crm.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.ldwx.crm.model.CustomerEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{

    @Value("${select.customer.by.id}")
    private String getById;
    @Value("${select.customer.by.email}")
    private String getByEmail;
    @Value("${select.customer.by.name}")
    private String getByName;
    @Value("${select.customer.by.phonenumber}")
    private String getByPhone;

    private NamedParameterJdbcTemplate jdbcTemplate;

    public CustomerRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<CustomerEntity> get(int id) {
        return jdbcTemplate.query(getById,
                new MapSqlParameterSource("id", id),
                (rs, rowNum) -> new CustomerEntity(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("phonenumber"),
                        rs.getString("email")
                )).stream().findAny();
    }

    @Override
    public Optional<CustomerEntity> getByEmail(String email) {
        return jdbcTemplate.query(getByEmail,
                new MapSqlParameterSource("email", email),
                (rs, rowNum) -> new CustomerEntity(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("phonenumber"),
                        rs.getString("email")
                )).stream().findAny();
    }

    @Override
    public List<CustomerEntity> findByName(String name) {
        return  jdbcTemplate.query(getByName,
                new MapSqlParameterSource("name", "%" + name + "%"),
                new BeanPropertyRowMapper<>(CustomerEntity.class));

    }

    @Override
    public List<CustomerEntity> findByPhone(String phonenumber) {
        return jdbcTemplate.query(getByPhone,
                new MapSqlParameterSource("phonenumber", "%" + phonenumber + "%"),
                new BeanPropertyRowMapper<>(CustomerEntity.class)
        );
    }
}
