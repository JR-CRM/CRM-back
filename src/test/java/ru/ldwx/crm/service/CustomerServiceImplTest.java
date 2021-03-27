package ru.ldwx.crm.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ldwx.crm.data.CustomerTestData;
import ru.ldwx.crm.model.CustomerDto;
import ru.ldwx.crm.model.CustomerEntity;
import ru.ldwx.crm.repository.CustomerRepository;
import ru.ldwx.crm.repository.CustomerRepositoryImpl;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class CustomerServiceImplTest {

    private CustomerService customerService;
    private CustomerRepository customerRepository;

    @BeforeEach
    void init() {
        customerRepository = mock(CustomerRepository.class);
        customerService = new CustomerServiceImpl(customerRepository);
    }

    @Test
    void getShouldReturnCustomerDto() {
        int id = 1;
        given(customerRepository.get(id)).willReturn(CustomerTestData.getCustomerEntity());
        CustomerDto customer = customerService.get(id);
        assertEquals(CustomerTestData.getCustomerDto(), customer);
    }

    @Test
    void getShouldThrowNoSuchElementException() {
        int id = 4;
        given(customerRepository.get(id)).willReturn(Optional.empty());
        assertThrows(NoSuchElementException.class,
                () -> customerService.get(id));
    }

    @Test
    void getByEmailShouldReturnCustomerDto() {
        String email = "pet@mail.ru";
        given(customerRepository.getByEmail(email)).willReturn(CustomerTestData.getCustomerEntity());
        CustomerDto customer = customerService.getByEmail(email);
        assertEquals(CustomerTestData.getCustomerDto(), customer);
    }

    @Test
    void getByEmailShouldThrowNoSuchElementException() {
        String email = "pel.ru";
        given(customerRepository.getByEmail(email)).willReturn(Optional.empty());
        assertThrows(NoSuchElementException.class,
                () -> customerService.getByEmail(email));
    }

    @Test
    void find() {
    }
}