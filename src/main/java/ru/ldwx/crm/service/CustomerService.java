package ru.ldwx.crm.service;

import ru.ldwx.crm.model.CustomerDto;

import java.util.List;

public interface CustomerService {

    CustomerDto get(int id);

    CustomerDto getByEmail(String email);

    List<CustomerDto> find(String query);
}
