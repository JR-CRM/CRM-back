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
import ru.ldwx.crm.data.CustomerTestData;
import ru.ldwx.crm.model.CustomerEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@JdbcTest
@TestPropertySource("classpath:sql-query.properties")
@Sql(scripts = {"classpath:customer_schema.sql", "classpath:customer_data.sql"})
class CustomerRepositoryImplTest {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    private CustomerRepository repository;

    @Value("${select.customer.by.id}")
    private String getById;
    @Value("${select.customer.by.email}")
    private String getByEmail;
    @Value("${select.customer.by.name}")
    private String getByName;
    @Value("${select.customer.by.phonenumber}")
    private String getByPhone;

    @BeforeEach
    void init() {
        repository = new CustomerRepositoryImpl(jdbcTemplate);
        ReflectionTestUtils.setField(repository, "getById", getById);
        ReflectionTestUtils.setField(repository, "getByEmail", getByEmail);
        ReflectionTestUtils.setField(repository, "getByName", getByName);
        ReflectionTestUtils.setField(repository, "getByPhone", getByPhone);
    }

    @Test
    void getShouldWork() {
        int id = 1;
        Optional<CustomerEntity> customer = repository.get(id);
        assertEquals(CustomerTestData.getCustomerWithFirstId(), customer);
    }

    @Test
    void getByEmailShouldWork() {
        String email = "pet@mail.ru";
        Optional<CustomerEntity> customer = repository.getByEmail(email);
        assertEquals(CustomerTestData.getCustomerByEmail(), customer);

    }

    @Test
    void findByNameShouldWork() {
        String name = "Peter";
        List<CustomerEntity> customers = repository.findByName(name);
        assertEquals(customers.size(), 1);
        assertEquals(CustomerTestData.getCustomersByName(), customers);
    }

    @Test
    void findByPhoneShouldWork() {
        String phone = "+79001582323";
        List<CustomerEntity> customers = repository.findByPhone(phone);
        assertEquals(customers.size(), 1);
        assertEquals(CustomerTestData.getCustomersByPhoneNumber(), customers);
    }
}
