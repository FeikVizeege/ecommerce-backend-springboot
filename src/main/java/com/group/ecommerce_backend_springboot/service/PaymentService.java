package com.group.ecommerce_backend_springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.ecommerce_backend_springboot.model.Payment;
import com.group.ecommerce_backend_springboot.repository.PaymentRepository;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }
}
