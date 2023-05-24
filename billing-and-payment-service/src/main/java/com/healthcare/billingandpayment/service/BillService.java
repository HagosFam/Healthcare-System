package com.healthcare.billingandpayment.service;

import com.healthcare.billingandpayment.controller.BillController;
import com.healthcare.billingandpayment.service.adapter.BillAdapter;
import com.healthcare.billingandpayment.service.dto.BillDto;
import com.healthcare.billingandpayment.service.dto.BillsDto;
import com.healthcare.billingandpayment.domain.Bill;
import com.healthcare.billingandpayment.repository.IBillRepo;
import com.healthcare.billingandpayment.repository.IPaymentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BillService implements IBillService {
    @Autowired
    private IBillRepo billRepo;

    private static final Logger logger = LoggerFactory.getLogger(BillController.class);

    @Autowired
    private IPaymentRepo paymentRepo;

    @Override
    public BillDto findById(long id) {

        logger.info("Bill find: {}", id);

        return billRepo.findById(id).map(BillAdapter::getDtoFromBill).orElse(null);
    }

    @Override
    public BillsDto findByPatientId(long patientId) {

        logger.info("Bill find: patient-id={}", patientId);

        List<Bill> bills = billRepo.findByPatientId(patientId);
        return new BillsDto(BillAdapter.getDtosFromBills(bills));
    }

    @Override
    public BillsDto findAll() {

        logger.info("Bill find");

        List<Bill> bills = billRepo.findAll();
        return new BillsDto(BillAdapter.getDtosFromBills(bills));
    }

    @Override
    public BillDto save(BillDto billDto) {

        logger.info("Bill save: {}",billDto);

        var bill = billRepo.save(BillAdapter.getBillFromDto(billDto));
        return BillAdapter.getDtoFromBill(bill);
    }

    @Override
    public void deleteById(long id) {

        logger.info("Bill delete: {}",id);

        billRepo.deleteById(id);
    }

    @Override
    public void deleteAll() {

        logger.info("Bill deleteAll");

        billRepo.deleteAll();
    }

    @Override
    public BillDto update(long id, BillDto billDto) {

        logger.info("Bill update: {}/{}",id, billDto);

        var bill = billRepo.update(id, BillAdapter.getBillFromDto(billDto));
        return BillAdapter.getDtoFromBill(bill);
    }
}
