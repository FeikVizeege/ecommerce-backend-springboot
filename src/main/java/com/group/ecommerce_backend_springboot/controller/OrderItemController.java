package com.group.ecommerce_backend_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group.ecommerce_backend_springboot.model.OrderItem;
import com.group.ecommerce_backend_springboot.service.OrderItemService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @PostMapping
    public ResponseEntity<OrderItem> postMethodName(@RequestBody OrderItem orderItem) {
        OrderItem createdOrderItem = orderItemService.createOrderItem(orderItem);
        return ResponseEntity.ok(createdOrderItem);
    }
    
    
}
