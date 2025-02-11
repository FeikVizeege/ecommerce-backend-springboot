package com.group.ecommerce_backend_springboot.model;

import java.math.BigDecimal;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "order_items")
public class OrderItem {
    @Id
    private ObjectId id;

    private long quantity;
    private BigDecimal price;

    public OrderItem(ObjectId id, long quantity, BigDecimal price) {
        super();
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    public ObjectId getId() {
        return id;
    }
    public void setId(ObjectId id) {
        this.id = id;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public long getQuantity() {
        return quantity;
    }
    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
