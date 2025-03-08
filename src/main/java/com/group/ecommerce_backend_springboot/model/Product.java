package com.group.ecommerce_backend_springboot.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {
    @Id
    private ObjectId id;
    @DBRef
    private Category category;

    private String name;
    private String description;
    private BigDecimal currPrice;
    private long stockQuantity;
    private String imageUrl;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public Product(ObjectId id, Category category, String name, String description, BigDecimal currPrice, long stockQuantity, String imageUrl, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super();
        this.id = id;
        this.category = category;
        this.name = name;
        this.description = description;
        this.currPrice = currPrice;
        this.stockQuantity = stockQuantity;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public ObjectId getId() {
        return id;
    }
    public void setId(ObjectId id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public BigDecimal getPrice() {
        return currPrice;
    }
    public void setPrice(BigDecimal currPrice) {
        this.currPrice = currPrice;
    }
    public long getStockQuantity() {
        return stockQuantity;
    }
    public void setStockQuantity(long stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
}
