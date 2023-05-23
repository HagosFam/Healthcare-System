package com.healthcare.billingandpayment.service.adapter;

import com.healthcare.billingandpayment.domain.Bill;
import com.healthcare.billingandpayment.domain.Payment;
import com.healthcare.billingandpayment.service.dto.BillDto;
import com.healthcare.billingandpayment.service.dto.PaymentDto;

import java.util.ArrayList;
import java.util.List;

public class BillAdapter {
    public static BillDto getDtoFromBill(Bill bill) {

        PaymentDto paymentDto = null;
        if(bill.getPayment() != null)
            paymentDto = PaymentAdapter.getDtoFromPayment(bill.getPayment());

        return BillDto.builder()
                .id(bill.getId())
                .patientId(bill.getPatientId())
                .servicesRendered(bill.getServicesRendered())
                .payment(paymentDto)
                .build();
    }

    public static Bill getBillFromDto(BillDto billDto) {

        Payment payment = null;
        if (billDto.getPayment() != null)
            payment = PaymentAdapter.getPaymentFromDto(billDto.getPayment());

        return Bill.builder()
                .id(billDto.getId())
                .patientId(billDto.getPatientId())
                .servicesRendered(billDto.getServicesRendered())
                .payment(payment)
                .build();
    }

    public static List<BillDto> getDtosFromBills(List<Bill> bills) {
        List<BillDto> dtos = new ArrayList<>();
        for (Bill bill : bills)
            dtos.add(getDtoFromBill(bill));
        return dtos;
    }

    public static List<Bill> getBillsFromDtos(List<BillDto> billsDtos) {
        List<Bill> bills = new ArrayList<>();
        for (BillDto dto : billsDtos)
            bills.add(getBillFromDto(dto));
        return bills;
    }
}
