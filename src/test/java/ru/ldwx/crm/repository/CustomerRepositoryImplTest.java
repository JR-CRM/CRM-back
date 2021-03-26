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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void getShouldBeNull() {
        int id = 0;
        Optional<CustomerEntity> customer = repository.get(id);
        assertEquals(Optional.empty(), customer);
    }

    @Test
    void getByEmailShouldWork() {
        String email = "pet@mail.ru";
        Optional<CustomerEntity> customer = repository.getByEmail(email);
        assertEquals(CustomerTestData.getCustomerByEmail(), customer);
    }

    @Test
    void getByEmailShouldBeNull() {
        String email = "Not correct email";
        Optional<CustomerEntity> customer = repository.getByEmail(email);
        assertEquals(Optional.empty(), customer);
    }

    @Test
    void findByNameShouldWork() {
        String name = "Peter";
        List<CustomerEntity> customers = repository.findByName(name);
        assertEquals(1, customers.size());
        assertEquals(CustomerTestData.getCustomerByName(), customers);
    }

    @Test
    void findByNameShouldReturnByTag() {
        String nameTag = "ter";
        List<CustomerEntity> customers = repository.findByName(nameTag);
        assertEquals(1, customers.size());
        assertEquals(CustomerTestData.getCustomerByName(), customers);
    }

    @Test
    void findByNameShouldReturnSomeCustomersByTag() {
        String nameTag = "e";
        List<CustomerEntity> customers = repository.findByName(nameTag);
        assertEquals(2, customers.size());
        assertEquals(CustomerTestData.getCustomersByNameTag(), customers);
    }

    @Test
    void findByNameShouldReturnCustomerByTagWithUppercase() {
        String nameTag = "P";
        List<CustomerEntity> customers = repository.findByName(nameTag);
        assertEquals(1, customers.size());
        assertEquals(CustomerTestData.getCustomerByName(), customers);
    }

    @Test
    void findByNameShouldBeNull() {
        String name = "No name";
        List<CustomerEntity> nullCustomers = repository.findByName(name);
        assertTrue(nullCustomers.isEmpty());
        assertEquals(0, nullCustomers.size());
    }

    @Test
    void findByPhoneShouldWork() {
        String phone = "79001582323";
        List<CustomerEntity> customers = repository.findByPhone(phone);
        assertEquals(1, customers.size());
        assertEquals(CustomerTestData.getCustomerByPhoneNumber(), customers);
    }

    @Test
    void findByPhoneShouldReturnByTag() {
        String partOfPhone = "582323";
        List<CustomerEntity> customers = repository.findByPhone(partOfPhone);
        assertEquals(1, customers.size());
        assertEquals(CustomerTestData.getCustomerByPhoneNumber(), customers);
    }

    @Test
    void findByPhoneShouldReturnAllCustomersByTag() {
        String partOfPhone = "7";
        List<CustomerEntity> customers = repository.findByPhone(partOfPhone);
        assertEquals(3, customers.size());
        assertEquals(CustomerTestData.getCustomersByPhoneNumberWithTag(), customers);
    }

    @Test
    void findByPhoneShouldBeNull() {
        String phone = "Not correct phone";
        List<CustomerEntity> nullCustomers = repository.findByPhone(phone);
        assertTrue(nullCustomers.isEmpty());
        assertEquals(0, nullCustomers.size());
    }
}
