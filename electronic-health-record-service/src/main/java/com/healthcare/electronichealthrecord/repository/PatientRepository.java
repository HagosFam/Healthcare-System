package com.healthcare.electronichealthrecord.repository;

import com.healthcare.electronichealthrecord.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
}
