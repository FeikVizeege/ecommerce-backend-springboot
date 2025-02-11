package com.group.ecommerce_backend_springboot.service;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.ecommerce_backend_springboot.model.Product;
import com.group.ecommerce_backend_springboot.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> getProductById(ObjectId id) {
        return productRepository.findById(id);
    }

    public void deleteProductById(ObjectId id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) productRepository.deleteById(id);
        else throw new RuntimeException("Product not found!");
    }
}
