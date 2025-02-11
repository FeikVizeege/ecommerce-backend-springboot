package com.group.ecommerce_backend_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.ecommerce_backend_springboot.model.OrderItem;
import com.group.ecommerce_backend_springboot.repository.OrderItemRepository;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
}
