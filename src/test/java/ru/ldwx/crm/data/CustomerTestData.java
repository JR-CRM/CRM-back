package ru.ldwx.crm.data;

import ru.ldwx.crm.model.CustomerDto;
import ru.ldwx.crm.model.CustomerEntity;

import java.util.List;
import java.util.Optional;

public class CustomerTestData {

    public static Optional<CustomerEntity> getCustomerWithFirstId() {
        return Optional.of(new CustomerEntity(1, "Peter", "+79001582323", "pet@mail.ru"));
    }

    public static Optional<CustomerEntity> getCustomerByEmail() {
        return Optional.of(new CustomerEntity(1, "Peter", "+79001582323", "pet@mail.ru"));
    }

    public static List<CustomerEntity> getCustomersByName() {
        return List.of(new CustomerEntity(1, "Peter", "+79001582323", "pet@mail.ru"));
    }

    public static List<CustomerEntity> getCustomersByPhoneNumber() {
        return List.of(new CustomerEntity(1, "Peter", "+79001582323", "pet@mail.ru"));
    }

    public static Optional<CustomerEntity> getCustomerEntity() {
        return Optional.of(new CustomerEntity(1, "Peter", "+79001582323", "pet@mail.ru"));
    }

    public static CustomerDto getCustomerDto() {
        return new CustomerDto(1, "Peter", "+79001582323", "pet@mail.ru");
    }

}
