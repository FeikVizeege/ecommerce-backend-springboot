package com.group.ecommerce_backend_springboot.model;

import java.math.BigDecimal;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "order_items")
public class OrderItem {
    @Id
    private ObjectId id;

    @DBRef
    private Order order;
    @DBRef
    private Product product;

    private long quantity;
    private BigDecimal orderedPrice;

    public OrderItem(ObjectId id, Order order, Product product, long quantity, BigDecimal orderedPrice) {
        super();
        this.id = id;
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.orderedPrice = orderedPrice;
    }

    public ObjectId getId() {
        return id;
    }
    public void setId(ObjectId id) {
        this.id = id;
    }
    public BigDecimal getPrice() {
        return orderedPrice;
    }
    public void setPrice(BigDecimal orderedPrice) {
        this.orderedPrice = orderedPrice;
    }
    public long getQuantity() {
        return quantity;
    }
    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
}
