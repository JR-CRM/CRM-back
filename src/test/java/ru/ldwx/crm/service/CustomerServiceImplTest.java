package ru.ldwx.crm.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ldwx.crm.data.CustomerTestData;
import ru.ldwx.crm.model.CustomerDto;
import ru.ldwx.crm.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
    void getShouldReturnEmptyCustomer() {
        int id = 4;
        given(customerRepository.get(id)).willReturn(Optional.empty());
        CustomerDto emptyCustomer = customerService.get(id);
        assertEquals(new CustomerDto(), emptyCustomer);
    }

    @Test
    void getByEmailShouldReturnCustomerDto() {
        String email = "pet@mail.ru";
        given(customerRepository.getByEmail(email)).willReturn(CustomerTestData.getCustomerEntity());
        CustomerDto customer = customerService.getByEmail(email);
        assertEquals(CustomerTestData.getCustomerDto(), customer);
    }

    @Test
    void getByEmailShouldReturnEmptyCustomer() {
        String email = "pel.ru";
        given(customerRepository.getByEmail(email)).willReturn(Optional.empty());
        CustomerDto emptyCustomer = customerService.getByEmail(email);
        assertEquals(new CustomerDto(), emptyCustomer);
    }

    @Test
    void findShouldReturnCustomerByPhone() {
        String query = "79001582323";
        given(customerRepository.findByPhone(query)).willReturn(CustomerTestData.getCustomerByQuery());
        List<CustomerDto> customers = customerService.find(query);
        verify(customerRepository).findByPhone(query);
        assertEquals(CustomerTestData.getCustomerDto(), customers.get(0));
    }

    @Test
    void findShouldReturnEmptyCustomerByPhone() {
        String query = "3333";
        given(customerRepository.findByPhone(query)).willReturn(Collections.emptyList());
        List<CustomerDto> customers = customerService.find(query);
        verify(customerRepository).findByPhone(query);
        assertTrue(customers.isEmpty());
    }

    @Test
    void findShouldReturnCustomerByName() {
        String query = "Peter";
        given(customerRepository.findByName(query)).willReturn(CustomerTestData.getCustomerByQuery());
        List<CustomerDto> customers = customerService.find(query);
        verify(customerRepository).findByName(query);
        assertEquals(CustomerTestData.getCustomerDto(), customers.get(0));
    }

    @Test
    void findShouldReturnEmptyCustomerByName() {
        String query = "zero";
        given(customerRepository.findByName(query)).willReturn(Collections.emptyList());
        List<CustomerDto> customers = customerService.find(query);
        verify(customerRepository).findByName(query);
        assertTrue(customers.isEmpty());
    }
}