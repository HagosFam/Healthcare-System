package com.healthcare.billingandpayment.service.adapter;

import com.healthcare.billingandpayment.domain.Payment;
import com.healthcare.billingandpayment.service.dto.PaymentDto;

import java.util.ArrayList;
import java.util.List;

public class PaymentAdapter {
    public static PaymentDto getDtoFromPayment(Payment payment){
        return PaymentDto.builder()
                .id(payment.getId())
                .amount(payment.getAmount())
                .paymentDate(payment.getPaymentDate())
                .build();
    }

    public static Payment getPaymentFromDto(PaymentDto payment){
        return Payment.builder()
                .id(payment.getId())
                .amount(payment.getAmount())
                .paymentDate(payment.getPaymentDate())
                .build();
    }

    public static List<PaymentDto> getDtosFromPayments(List<Payment> payments){
        List<PaymentDto> dtos = new ArrayList<>();
        for(Payment payment: payments)
            dtos.add(getDtoFromPayment(payment));
        return dtos;
    }

    public static List<Payment> getPaymentsFromDtos(List<PaymentDto> dtos){
        List<Payment> payments = new ArrayList<>();
        for(PaymentDto dto: dtos)
            payments.add(getPaymentFromDto(dto));
        return payments;
    }
}
