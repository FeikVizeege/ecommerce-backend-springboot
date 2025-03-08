package com.group.ecommerce_backend_springboot.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payments")
public class Payment {
    enum PaymentStatus {
        COMPLETED,
        PENDING,
        REFUNDED,
    }

    @Id
    private ObjectId id;
    @DBRef
    private Order order;

    private String method;
    private BigDecimal amount;
    private PaymentStatus status;
    @CreatedDate
    private LocalDateTime paymentDate;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public Payment(ObjectId id, Order order, String method, BigDecimal amount, PaymentStatus status, LocalDateTime paymentDate, LocalDateTime updatedAt) {
        super();
        this.id = id;
        this.order = order;
        this.method = method;
        this.amount = amount;
        this.status = status;
        this.paymentDate = paymentDate;
        this.updatedAt = updatedAt;
    }

    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public ObjectId getId() {
        return id;
    }
    public void setId(ObjectId id) {
        this.id = id;
    }
    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }
    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }
    public PaymentStatus getStatus() {
        return status;
    }
    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
}
