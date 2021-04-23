package ru.ldwx.crm.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class CustomerOrderEntity {
    private List<ProductEntity> productList;
    private BigDecimal orderTotalSum;
    private BigDecimal paidByCustomerSum;
    private String comment;

    public CustomerOrderEntity(
            List<ProductEntity> productList, BigDecimal orderTotalSum, BigDecimal paidByCustomerSum, String comment) {
        this.productList = productList;
        this.orderTotalSum = orderTotalSum;
        this.paidByCustomerSum = paidByCustomerSum;
        this.comment = comment;
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

        if (productList != null ? !productList.equals(that.productList) : that.productList != null) return false;
        if (orderTotalSum != null ? !orderTotalSum.equals(that.orderTotalSum) : that.orderTotalSum != null)
            return false;
        if (paidByCustomerSum != null ? !paidByCustomerSum.equals(that.paidByCustomerSum) : that.paidByCustomerSum != null)
            return false;
        return comment != null ? comment.equals(that.comment) : that.comment == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productList, orderTotalSum, paidByCustomerSum, comment);
    }
}
