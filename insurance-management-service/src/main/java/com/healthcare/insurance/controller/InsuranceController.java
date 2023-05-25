package com.healthcare.insurance.controller;

import com.healthcare.insurance.service.InsuranceService;
import com.healthcare.insurance.model.InsuranceClaim;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/insurances")
@Slf4j
public class InsuranceController {
    private final InsuranceService insuranceService;

    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @PostMapping("/claims")
    public ResponseEntity<InsuranceClaim> createClaim(@RequestBody InsuranceClaim insuranceClaim) {

        log.info("Insurance createCalim: {}", insuranceClaim);

        InsuranceClaim createdClaim = insuranceService.createClaim(insuranceClaim);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClaim);
    }

    @GetMapping("/claims/patient/{patientId}")
    public ResponseEntity<List<InsuranceClaim>> getInsuranceClaimsByPatientId(@PathVariable long patientId) {

        log.info("Insurance getInsuranceClaims: patient-id={}", patientId);

        List<InsuranceClaim> insuranceClaims = insuranceService.getInsuranceClaimByPatientId(patientId);
        return ResponseEntity.ok(insuranceClaims);
    }

    @GetMapping("/claims/{id}")
    public ResponseEntity<InsuranceClaim> getInsuranceClaimById(@PathVariable String id) {

        log.info("Insurance getInsuranceClaim: {}", id);

        InsuranceClaim insuranceClaim = insuranceService.getInduranceById(id);
        if (insuranceClaim != null) {
            return ResponseEntity.ok(insuranceClaim);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/claims/file")
    public ResponseEntity<InsuranceClaim> fileClaim(@RequestBody InsuranceClaim insuranceClaim) {

        log.info("Insurance fileClaim: {}", insuranceClaim);

        InsuranceClaim filedClaim = insuranceService.fileClaim(insuranceClaim);
        return ResponseEntity.ok(filedClaim);
    }
}
