package com.group.ecommerce_backend_springboot.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
public class Order {
    enum OrderStatus {
        PENDING,
        SHIPPED,
        DELIVERED
    }

    @Id
    private ObjectId id;
    @DBRef
    private List<OrderItem> orderItems;

    private BigDecimal totalAmount;
    private String shippingAddress;
    private String billingAddress;
    private OrderStatus status;
    @CreatedDate
    private LocalDateTime orderedDate;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public Order(ObjectId id, List<OrderItem> orderItems, BigDecimal totalAmount, String shippingAddress, String billingAddress, OrderStatus status, LocalDateTime orderedDate, LocalDateTime updatedAt) {
        super();
        this.id = id;
        this.orderItems = orderItems;
        this.totalAmount = totalAmount;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.status = status;
        this.orderedDate = orderedDate;
        this.updatedAt = updatedAt;
    }

    public String getBillingAddress() {
        return billingAddress;
    }
    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }
    public ObjectId getId() {
        return id;
    }
    public void setId(ObjectId id) {
        this.id = id;
    }
    public LocalDateTime getOrderedDate() {
        return orderedDate;
    }
    public void setOrderedDate(LocalDateTime orderedDate) {
        this.orderedDate = orderedDate;
    }
    public String getShippingAddress() {
        return shippingAddress;
    }
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    public OrderStatus getStatus() {
        return status;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
