package com.healthcare.billingandpayment.repository;

import com.healthcare.billingandpayment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentRepo extends JpaRepository<Payment, Long> {
}
