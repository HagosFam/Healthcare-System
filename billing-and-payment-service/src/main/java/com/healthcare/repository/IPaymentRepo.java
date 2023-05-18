package com.healthcare.repository;

import com.healthcare.domain.Bill;
import com.healthcare.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPaymentRepo extends JpaRepository<Payment, Long> {
}
