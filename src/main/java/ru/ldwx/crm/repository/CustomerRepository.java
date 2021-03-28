package ru.ldwx.crm.repository;

import ru.ldwx.crm.model.CustomerEntity;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    /**
     * Возвращает заказчика по id
     * @param id - уникальный номер заказчика
     * @return Optional<CustomerEntity> - заказчик, либо empty если заказчик не найден
     */
    Optional<CustomerEntity> get(int id);

    /**
     * Возвращает заказчика по email адресу
     * @param email - email адрес заказчика
     * @return Optional<CustomerEntity> - заказчик, либо empty если заказчик не найден
     */
    Optional<CustomerEntity> getByEmail(String email);

    /**
     * Возвращает список заказчиков с указанным именем или частью имени. В запросе передается полное имя или часть имени.
     * @param name - полное имя или часть имени
     * @return List<CustomerEntity> - список заказчиков подходящий под данные критерии
     */
    List<CustomerEntity> findByName(String name);

    /**
     * Возвращает список заказчиков с указанным телефоном или частью телефона. В запросе передается номер телефона или его часть.
     * @param phone - номер телефона или его часть
     * @return List<CustomerEntity> - список заказчиков подходящий под данные критерии
     */
    List<CustomerEntity> findByPhone(String phone);
}
