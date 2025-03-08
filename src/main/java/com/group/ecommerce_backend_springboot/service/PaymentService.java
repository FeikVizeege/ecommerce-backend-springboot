package com.group.ecommerce_backend_springboot.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
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

    public Optional<Payment> getPaymentById(ObjectId id) {
        return paymentRepository.findById(id);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public void deletePaymentById(ObjectId id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        if (payment.isPresent()) paymentRepository.deleteById(id);
        else throw new RuntimeException("Payment not found!");
    }
}
