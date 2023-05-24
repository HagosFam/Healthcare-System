package com.healthcare.billingandpayment.service;

import com.healthcare.billingandpayment.service.dto.BillDto;
import com.healthcare.billingandpayment.service.dto.BillsDto;

public interface IBillService {
    BillDto findById(long id);
    BillsDto findByPatientId(long patientId);
    BillsDto findAll();
    BillDto save(BillDto billDto);
    void deleteById(long id);
    void deleteAll();
    BillDto update(long id, BillDto billDto);
}
