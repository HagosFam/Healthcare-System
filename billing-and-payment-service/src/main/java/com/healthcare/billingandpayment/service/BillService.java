package com.healthcare.billingandpayment.service;

import com.healthcare.billingandpayment.service.adapter.BillAdapter;
import com.healthcare.billingandpayment.service.dto.BillDto;
import com.healthcare.billingandpayment.service.dto.BillsDto;
import com.healthcare.billingandpayment.domain.Bill;
import com.healthcare.billingandpayment.repository.IBillRepo;
import com.healthcare.billingandpayment.repository.IPaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BillService implements IBillService {
    @Autowired
    private IBillRepo billRepo;

    @Autowired
    private IPaymentRepo paymentRepo;

    @Override
    public BillDto findById(long id) {
        return billRepo.findById(id).map(BillAdapter::getDtoFromBill).orElse(null);
    }

    @Override
    public BillsDto findByPatientId(long patientId) {
        List<Bill> bills = billRepo.findByPatientId(patientId);
        return new BillsDto(BillAdapter.getDtosFromBills(bills));
    }

    @Override
    public BillsDto findAll() {
        List<Bill> bills = billRepo.findAll();
        return new BillsDto(BillAdapter.getDtosFromBills(bills));
    }

    @Override
    public BillDto save(BillDto billDto) {
        var bill = billRepo.save(BillAdapter.getBillFromDto(billDto));
        return BillAdapter.getDtoFromBill(bill);
    }

    @Override
    public void deleteById(long id) {
        billRepo.deleteById(id);
    }

    @Override
    public void deleteAll() {
        billRepo.deleteAll();
    }

    @Override
    public BillDto update(long id, BillDto billDto) {
        var bill = billRepo.update(id, BillAdapter.getBillFromDto(billDto));
        return BillAdapter.getDtoFromBill(bill);
    }
}
