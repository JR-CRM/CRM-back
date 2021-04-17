package ru.ldwx.crm.service;

import ru.ldwx.crm.model.CustomerDto;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Optional<CustomerDto> get(int id);

    Optional<CustomerDto> getByEmail(String email);

    List<CustomerDto> find(String query);
}
