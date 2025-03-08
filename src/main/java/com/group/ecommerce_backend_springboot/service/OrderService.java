package com.group.ecommerce_backend_springboot.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.ecommerce_backend_springboot.model.Order;
import com.group.ecommerce_backend_springboot.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Optional<Order> getOrderById(ObjectId id) {
        return orderRepository.findById(id);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void deleteOrderById(ObjectId id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) orderRepository.deleteById(id);
        else throw new RuntimeException("Order not found!");
    }
}
