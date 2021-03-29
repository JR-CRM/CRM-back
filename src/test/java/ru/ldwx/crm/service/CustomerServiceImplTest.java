package ru.ldwx.crm.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ldwx.crm.data.CustomerTestData;
import ru.ldwx.crm.model.CustomerDto;
import ru.ldwx.crm.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        String phone = "79001582323";
        given(customerRepository.findByPhone(phone)).willReturn(CustomerTestData.getCustomersByPhoneNumber());
        List<CustomerDto> customers = customerService.find(phone);
        verify(customerRepository).findByPhone(phone);
        assertEquals(CustomerTestData.getCustomerDto(), customers.get(0));
    }

    @Test
    void findShouldReturnEmptyCustomerByPhone() {
        String phone = "3333";
        given(customerRepository.findByPhone(phone)).willReturn(new ArrayList<>());
        List<CustomerDto> customers = customerService.find(phone);
        verify(customerRepository).findByPhone(phone);
        assertEquals(new ArrayList<>(), customers);
    }

    @Test
    void findShouldReturnCustomerByName() {
        String name = "Peter";
        given(customerRepository.findByName(name)).willReturn(CustomerTestData.getCustomersByName());
        List<CustomerDto> customers = customerService.find(name);
        verify(customerRepository).findByName(name);
        assertEquals(CustomerTestData.getCustomerDto(), customers.get(0));
    }

    @Test
    void findShouldReturnEmptyCustomerByName() {
        String name = "zero";
        given(customerRepository.findByName(name)).willReturn(new ArrayList<>());
        List<CustomerDto> customers = customerService.find(name);
        verify(customerRepository).findByName(name);
        assertEquals(new ArrayList<>(), customers);
    }
}