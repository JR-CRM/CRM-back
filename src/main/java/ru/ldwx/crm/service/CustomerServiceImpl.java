package ru.ldwx.crm.service;

import org.springframework.stereotype.Service;
import ru.ldwx.crm.model.CustomerDto;
import ru.ldwx.crm.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto get(int id) {
        return null;
    }

    @Override
    public CustomerDto getByEmail(String email) {
        return null;
    }

    @Override
    public List<CustomerDto> find(String query) {
        return null;
    }
}
