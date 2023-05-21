package com.healthcare.service.adapter;

import com.healthcare.domain.Bill;
import com.healthcare.domain.Payment;
import com.healthcare.service.dto.BillDto;
import com.healthcare.service.dto.PaymentDto;

import java.util.ArrayList;
import java.util.List;

public class BillAdapter {
    public static BillDto getDtoFromBill(Bill bill) {

        PaymentDto paymentDto = PaymentAdapter.getDtoFromPayment(bill.getPayment());

        return BillDto.builder()
                .id(bill.getId())
                .patientId(bill.getPatientId())
                .servicesRendered(bill.getServicesRendered())
                .payment(paymentDto)
                .build();
    }
    public static Bill getBillFromDto(BillDto billDto) {

        Payment payment = PaymentAdapter.getPaymentFromDto(billDto.getPayment());

        return Bill.builder()
                .id(billDto.getId())
                .patientId(billDto.getPatientId())
                .servicesRendered(billDto.getServicesRendered())
                .payment(payment)
                .build();
    }

    public static List<BillDto> getDtosFromBills(List<Bill> bills){
        List<BillDto> dtos = new ArrayList<>();
        for(Bill bill: bills)
            dtos.add(getDtoFromBill(bill));
        return dtos;
    }

    public static List<Bill> getBillsFromDtos(List<BillDto> billsDtos){
        List<Bill> bills = new ArrayList<>();
        for(BillDto dto: billsDtos)
            bills.add(getBillFromDto(dto));
        return bills;
    }
}
