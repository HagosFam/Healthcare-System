package com.healthcare.prescriptionmanagement.repository;


import com.healthcare.prescriptionmanagement.domain.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {

  //  List<Medication> findbyMedicationId(long medicationId);
}
