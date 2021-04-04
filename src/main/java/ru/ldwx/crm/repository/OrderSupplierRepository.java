package ru.ldwx.crm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ldwx.crm.model.OrderSupplierEntity;


@Repository
public interface OrderSupplierRepository extends CrudRepository<OrderSupplierEntity, Long> {

}
