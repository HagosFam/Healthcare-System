package com.healthcare.prescriptionmanagement.repository;

import com.healthcare.prescriptionmanagement.domain.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    Prescription findByPatientId(long patientId);


}
