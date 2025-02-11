package com.group.ecommerce_backend_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group.ecommerce_backend_springboot.model.Payment;
import com.group.ecommerce_backend_springboot.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment createdPayment = paymentService.createPayment(payment);
        return ResponseEntity.ok(createdPayment);
    }
    
}
