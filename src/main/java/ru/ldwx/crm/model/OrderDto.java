package ru.ldwx.crm.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class OrderDto {
    private Long id;
    private String order;
    private List<ProductDto> products;
    private Date orderDate;
    private double orderAmount;
    private Date deliveryDate;
    private String orderComment;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
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

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
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
        if (!(o instanceof OrderDto)) return false;
        OrderDto orderDto = (OrderDto) o;
        return Double.compare(orderDto.orderAmount, orderAmount) == 0 && Objects.equals(order, orderDto.order) && Objects.equals(products, orderDto.products) && Objects.equals(orderDate, orderDto.orderDate) && Objects.equals(deliveryDate, orderDto.deliveryDate) && Objects.equals(orderComment, orderDto.orderComment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, products, orderDate, orderAmount, deliveryDate, orderComment);
    }
}
