package ru.ldwx.crm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.Objects;

@Table("order_supplier")
public class OrderSupplierEntity {

    private @Id Long id;
    private String orderNumber;
    private String goodsList;
    private LocalDate orderDate;
    private String orderCost;
    private LocalDate deliveryDate;
    private String comment;


    public OrderSupplierEntity(String orderNumber, String goodsList, LocalDate orderDate, String orderCost, LocalDate deliveryDate, String comment) {
        this.orderNumber = orderNumber;
        this.goodsList = goodsList;
        this.orderDate = orderDate;
        this.orderCost = orderCost;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderSupplierEntity that = (OrderSupplierEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(orderNumber, that.orderNumber) && Objects.equals(goodsList, that.goodsList) && Objects.equals(orderDate, that.orderDate) && Objects.equals(orderCost, that.orderCost) && Objects.equals(deliveryDate, that.deliveryDate) && Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderNumber, goodsList, orderDate, orderCost, deliveryDate, comment);
    }
}
