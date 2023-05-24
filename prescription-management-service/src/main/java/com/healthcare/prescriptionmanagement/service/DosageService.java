package com.healthcare.prescriptionmanagement.service;

import com.healthcare.prescriptionmanagement.domain.Dosage;
import com.healthcare.prescriptionmanagement.repository.DosageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DosageService {

    @Autowired
    private DosageRepository dosageRepository;


    public Dosage getDosage(long dosageId){
        return dosageRepository.findById(dosageId).get();
    }

    public void creatDosage(Dosage dosage){
        dosageRepository.save(dosage);
    }
}
