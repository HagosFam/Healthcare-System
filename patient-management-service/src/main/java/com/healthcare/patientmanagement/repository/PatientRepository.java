package com.healthcare.patientmanagement.repository;

import com.healthcare.patientmanagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> getPatientByPhoneNumberOrEmail(String phoneNumber, String email);
    Optional<Patient> getPatientByPhoneNumber(String phoneNumner);
    Optional<Patient> getPatientByEmail(String email);
}
