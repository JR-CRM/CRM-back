package ru.ldwx.crm.model;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductEntity {

    private Integer id;
    private String productNumber;
    private String productName;
    private String supplierLink;
    private BigDecimal price;
    private Integer quantity;

    public ProductEntity(Integer id, String productNumber, String productName, String supplierLink, BigDecimal price, Integer quantity) {
        this.id = id;
        this.productNumber = productNumber;
        this.productName = productName;
        this.supplierLink = supplierLink;
        this.price = price;
        this.quantity = quantity;
    }

    public ProductEntity(String productName, String supplierLink, BigDecimal price) {
        this.productName = productName;
        this.supplierLink = supplierLink;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSupplierLink() {
        return supplierLink;
    }

    public void setSupplierLink(String supplierLink) {
        this.supplierLink = supplierLink;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(productNumber, that.productNumber) && Objects.equals(productName, that.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productNumber, productName);
    }
}
