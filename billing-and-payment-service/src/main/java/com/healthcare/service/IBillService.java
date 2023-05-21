package com.healthcare.service;

import com.healthcare.service.dto.BillDto;
import com.healthcare.service.dto.BillsDto;

import java.util.List;

public interface IBillService {
    BillDto findById(long id);
    BillsDto findByPatientId(long patientId);
    BillsDto findAll();
    BillDto save(BillDto billDto);
    void deleteById(long id);
    void deleteAll();
    BillDto update(long id, BillDto billDto);
}
