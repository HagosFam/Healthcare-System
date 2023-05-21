package com.healthcare.insurance.repository;

import com.healthcare.insurance.model.InsuranceClaim;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface InsuranceClaimRepository extends MongoRepository<InsuranceClaim,String> {
    List<InsuranceClaim> findByPatientId(long patientId);
}
