package com.healthcare.prescriptionmanagement.repository;


import com.healthcare.prescriptionmanagement.domain.Dosage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DosageRepository extends JpaRepository<Dosage, Long> {
}
