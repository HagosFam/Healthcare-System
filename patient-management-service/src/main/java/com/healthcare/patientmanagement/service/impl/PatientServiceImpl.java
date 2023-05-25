package com.healthcare.patientmanagement.service.impl;

import com.healthcare.patientmanagement.dto.PatientDto;
import com.healthcare.patientmanagement.dto.Role;
import com.healthcare.patientmanagement.dto.User;
import com.healthcare.patientmanagement.entity.Patient;
import com.healthcare.patientmanagement.exception.EmailAlreadyExistsException;
import com.healthcare.patientmanagement.exception.PhoneNumberAlreadyExistsException;
import com.healthcare.patientmanagement.integration.feign.FeignIdentityManagementService;
import com.healthcare.patientmanagement.mapper.AutoPatientMapper;
import com.healthcare.patientmanagement.service.PatientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.healthcare.patientmanagement.exception.ResourceNotFoundException;
import com.healthcare.patientmanagement.repository.PatientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    private FeignIdentityManagementService identityManagementServiceUtil;

    @Override
    public PatientDto getPatient(Long id) {

        log.info("Patient get: {}", id);

        Patient patient = patientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient", "id", Long.toString(id)));
        return AutoPatientMapper.MAPPER.mapToPatientDto(patient);
    }

    @Override
    public PatientDto getPatientByPhoneNumberOrEmail(String phoneNumberOrEmail) {

        log.info("Patient getByPhoneNumberOrEmail: {}", phoneNumberOrEmail);

        Patient patient = patientRepository.getPatientByPhoneNumberOrEmail(phoneNumberOrEmail, phoneNumberOrEmail).orElseThrow(
                () -> new ResourceNotFoundException("Patient", "phoneNumberOrEmail", phoneNumberOrEmail)
        );
        return AutoPatientMapper.MAPPER.mapToPatientDto(patient);
    }

    @Override
    public List<PatientDto> getAllPatients() {

        log.info("Patient getAll");

        List<Patient> patients = patientRepository.findAll();
        List<PatientDto> patientsDto = new ArrayList<>();

        patients.stream().map((patient) -> patientsDto.add(AutoPatientMapper.MAPPER.mapToPatientDto(patient))).collect(Collectors.toList());

        return patientsDto;

    }

    @Override
    public PatientDto createPatient(PatientDto patientDto) {

        log.info("Patient create: {}", patientDto);

        if (patientRepository.getPatientByPhoneNumber(patientDto.getPhoneNumber()).isPresent()){
            log.info("Phone number already exists, {}", patientDto.getPhoneNumber());
            throw new PhoneNumberAlreadyExistsException("Phone number already exists!");
        }

        if (patientRepository.getPatientByEmail(patientDto.getEmail()).isPresent()){
            log.info("Email already exists, {}", patientDto.getEmail());
            throw  new EmailAlreadyExistsException("Email already exists!");
        }
        Patient newPatient = AutoPatientMapper.MAPPER.mapToPatient(patientDto);
        Patient savedPatient = patientRepository.save(newPatient);

        User user = new User(
                savedPatient.getId(),
                savedPatient.getEmail(),
                savedPatient.getFirstName(),
                savedPatient.getLastName(),
                "1234",
                Role.PATIENT
        );
        identityManagementServiceUtil.save(user);

        return AutoPatientMapper.MAPPER.mapToPatientDto(savedPatient);
    }

    @Override
    public PatientDto updatePatient(PatientDto patientDto) {

        log.info("Patient update: {}", patientDto);

        Patient patientToUpdate = patientRepository.findById(patientDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Patient", "id", Long.toString(patientDto.getId())));

        if(patientDto.getFirstName() != null) patientToUpdate.setFirstName(patientDto.getFirstName());
        if(patientDto.getLastName() != null) patientToUpdate.setLastName(patientDto.getLastName());
        if(patientDto.getAddress() != null) patientToUpdate.setAddress(patientDto.getAddress());
        if (patientDto.getInsuranceId() != null) patientToUpdate.setInsuranceId(patientDto.getInsuranceId());
        if(patientDto.getPhoneNumber() != null) patientToUpdate.setPhoneNumber(patientDto.getPhoneNumber());
        if (patientDto.getEmail() != null) patientToUpdate.setEmail(patientDto.getEmail());

        Patient updatedPatient = patientRepository.save(patientToUpdate);

        return AutoPatientMapper.MAPPER.mapToPatientDto(updatedPatient);
    }

    @Override
    public void deletePatient(Long id) {
        if(patientRepository.existsById(id)){
            patientRepository.deleteById(id);
        }
        else
            log.error("Patient not found: {}", id);
        //throw new ResourceNotFoundException("Patient", "id", Long.toString(id));
    }
}
