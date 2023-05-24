package com.healthcare.patientmanagement.service;

import com.healthcare.patientmanagement.dto.PatientDto;

import java.util.List;

public interface PatientService {

    PatientDto getPatient(Long id);
    PatientDto getPatientByPhoneNumberOrEmail(String phoneNumber);
    List<PatientDto> getAllPatients();
    PatientDto createPatient(PatientDto patientDto);
    PatientDto updatePatient(PatientDto patientDto);
    void deletePatient(Long id);
}
