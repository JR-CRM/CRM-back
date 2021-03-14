package ru.ldwx.crm.service;

import ru.ldwx.crm.model.SupplierOrderDto;

import java.util.List;

public interface SupplierOrderService {
    List<SupplierOrderDto> getAll();

    SupplierOrderDto getById(long id);
}
