package com.healthcare.insurance.service;

import com.healthcare.insurance.controller.InsuranceController;
import com.healthcare.insurance.model.InsuranceClaim;
import com.healthcare.insurance.model.enums.Status;
import com.healthcare.insurance.repository.InsuranceClaimRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class InsuranceService {
    private final InsuranceClaimRepository insuranceClaimRepository;

    public InsuranceClaim createClaim(InsuranceClaim insuranceClaim){
        insuranceClaimRepository.save(insuranceClaim);
        log.info("created claim sucessfully");
        return insuranceClaim;
    }
    public List<InsuranceClaim> getInsuranceClaimByPatientId(long patientId){
        log.info("fetching insurance claims for patient...");
        List<InsuranceClaim> InsuranceClaimByPatientId = insuranceClaimRepository.findByPatientId(patientId);
            return InsuranceClaimByPatientId;
    }
    public InsuranceClaim getInduranceById(String id){
        log.info("fetching insurance claim, for id:{}", id);
        Optional<InsuranceClaim> byId = insuranceClaimRepository.findById(id);
        if(byId.isPresent()){
            InsuranceClaim insuranceClaim = byId.get();
            return insuranceClaim;
        }
        else {
            log.error("insurance claim not found");
            return null;
        }
    }
    public InsuranceClaim fileClaim(InsuranceClaim insuranceClaim){
        insuranceClaim.setSubmissionDate(LocalDate.now());
        insuranceClaim.setStatus(Status.PENDING);
        insuranceClaimRepository.save(insuranceClaim);
        SendTObeAuthorizedByThirdParty(insuranceClaim);
        insuranceClaim.setStatus(Status.DONE);
        return insuranceClaim;

    }

    private void SendTObeAuthorizedByThirdParty(InsuranceClaim insuranceClaim) {
        log.info("insurance claim sent to insurance company to be reviewd.");
    }


}
