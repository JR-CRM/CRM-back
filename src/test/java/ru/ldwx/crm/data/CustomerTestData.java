package ru.ldwx.crm.data;

import ru.ldwx.crm.model.CustomerDto;
import ru.ldwx.crm.model.CustomerEntity;

import java.util.List;
import java.util.Optional;

public class CustomerTestData {

    public static Optional<CustomerEntity> getCustomerWithFirstId() {
        return Optional.of(new CustomerEntity(1, "Peter", "79001582323", "pet@mail.ru"));
    }

    public static Optional<CustomerEntity> getCustomerByEmail() {
        return Optional.of(new CustomerEntity(1, "Peter", "79001582323", "pet@mail.ru"));
    }

    public static List<CustomerEntity> getCustomerByName() {
        return List.of(new CustomerEntity(1, "Peter", "79001582323", "pet@mail.ru"));
    }

    public static List<CustomerEntity> getCustomerByPhoneNumber() {
        return List.of(new CustomerEntity(1, "Peter", "79001582323", "pet@mail.ru"));
    }

    public static List<CustomerEntity> getCustomersByNameTag() {
        return List.of(new CustomerEntity(1, "Peter", "79001582323", "pet@mail.ru"),
                new CustomerEntity(3, "Serg", "79003402023", "serg@mail.ru"));
    }

    public static Optional<CustomerEntity> getCustomerEntity() {
        return Optional.of(new CustomerEntity(1, "Peter", "79001582323", "pet@mail.ru"));
    }

    public static CustomerDto getCustomerDto() {
        return new CustomerDto(1, "Peter", "79001582323", "pet@mail.ru");
    }

    public static Optional<CustomerDto> getOptionalCustomerDto() {
        return Optional.of(new CustomerDto(1, "Peter", "79001582323", "pet@mail.ru"));
    }

    public static List<CustomerEntity> getCustomerByQuery() {
        return List.of(new CustomerEntity(1, "Peter", "79001582323", "pet@mail.ru"));
    }

    public static List<CustomerEntity> getCustomersByPhoneNumberWithTag() {
        return List.of(new CustomerEntity(1, "Peter", "79001582323", "pet@mail.ru"),
                new CustomerEntity(2, "Vasil", "79001584545", "v@mail.ru"),
                new CustomerEntity(3, "Serg", "79003402023", "serg@mail.ru"));
    }
}
