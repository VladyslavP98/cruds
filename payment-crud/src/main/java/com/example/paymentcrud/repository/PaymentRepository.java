package com.example.paymentcrud.repository;

import com.example.paymentcrud.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
