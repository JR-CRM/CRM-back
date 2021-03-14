package ru.ldwx.crm.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class SupplierOrderDto {
    private Long id;
    private String orderNumber;
    private List<ProductDto> products;
    private Date orderDate;
    private BigDecimal orderAmount;
    private Date deliveryDate;
    private String orderComment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getOrderComment() {
        return orderComment;
    }

    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SupplierOrderDto)) return false;
        SupplierOrderDto that = (SupplierOrderDto) o;
        return Objects.equals(id, that.id) && Objects.equals(orderNumber, that.orderNumber) &&
                Objects.equals(products, that.products) && Objects.equals(orderDate, that.orderDate) &&
                Objects.equals(orderAmount, that.orderAmount) && Objects.equals(deliveryDate, that.deliveryDate) &&
                Objects.equals(orderComment, that.orderComment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderNumber, products, orderDate, orderAmount, deliveryDate, orderComment);
    }
}
