package ru.ldwx.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ldwx.crm.model.CustomerEntity;
import ru.ldwx.crm.model.CustomerOrderEntity;

import java.util.List;
import java.util.Optional;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrderEntity, Long> {
    /**
     * Возвращает номер заказа по id
     * @param id - уникальный номер заказа покупателя
     * @return Optional<CustomerOrderEntity> - возвращает заказ покупателя, либо empty если заказ не найден
     */
    Optional<CustomerOrderEntity> getById(Long id);

    /**
     * Возвращает список заказов для данного покупателя
     * @param customer - покупатель
     * @return Optional<CustomerOrderEntity> - возвращает список заказов данного покупателя
     */
    List<CustomerOrderEntity> getAllByCustomer(CustomerEntity customer);

    /**
     * Сохраняет заказ в базу данных
     * @param order - заказ покупателя
     */
   void create(CustomerOrderEntity order);

    /**
     * Обновляет заказ в базе данных
     * @param order - заказ покупателя
     */
    void update(CustomerOrderEntity order);
}
