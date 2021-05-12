package ru.ldwx.crm.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class CustomerOrderEntity {
    private Long id;
    private CustomerEntity customer;
    private List<ProductEntity> productList;
    private BigDecimal orderTotalSum;
    private BigDecimal paidByCustomerSum;
    private String comment;

    public CustomerOrderEntity(CustomerEntity customer, List<ProductEntity> productList, BigDecimal orderTotalSum,
                               BigDecimal paidByCustomerSum, String comment) {
        this.customer = customer;
        this.productList = productList;
        this.orderTotalSum = orderTotalSum;
        this.paidByCustomerSum = paidByCustomerSum;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public List<ProductEntity> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductEntity> productList) {
        this.productList = productList;
    }

    public BigDecimal getOrderTotalSum() {
        return orderTotalSum;
    }

    public void setOrderTotalSum(BigDecimal orderTotalSum) {
        this.orderTotalSum = orderTotalSum;
    }

    public BigDecimal getPaidByCustomerSum() {
        return paidByCustomerSum;
    }

    public void setPaidByCustomerSum(BigDecimal paidByCustomerSum) {
        this.paidByCustomerSum = paidByCustomerSum;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerOrderEntity that = (CustomerOrderEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(customer, that.customer) &&
                Objects.equals(productList, that.productList) &&
                Objects.equals(orderTotalSum, that.orderTotalSum) &&
                Objects.equals(paidByCustomerSum, that.paidByCustomerSum) &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, productList, orderTotalSum, paidByCustomerSum, comment);
    }
}
