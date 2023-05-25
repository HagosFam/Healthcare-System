package com.healthcare.patientmanagement.controller;

import com.healthcare.patientmanagement.dto.PatientDto;
import com.healthcare.patientmanagement.service.PatientService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for Patient Resources",
        description = "CRUD REST APIs - Creat Patient, Update Patient, Get Patient, Get All Patients, Delete Patient " +
                "Find Patient By PhoneNumber or Email"
)
@RestController
@RequestMapping("api/v1/patients")
@AllArgsConstructor
@Slf4j
public class PatientController {

    private static final String SERVICE_PATIENT = "servicePatient";

    private PatientService patientService;

    @Operation(
            summary = "Create Patient REST API",
            description = "Create Patient REST API is used to save patient in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    @CircuitBreaker(name = SERVICE_PATIENT, fallbackMethod = "servicePatientFallback")
    public ResponseEntity<?> create(
            @Valid
            @RequestBody PatientDto patientDto){

        log.info("Patient create: {}", patientDto);

        PatientDto patient = patientService.createPatient(patientDto);

        return new ResponseEntity<>(patient, HttpStatus.CREATED);
    }
    @Operation(
            summary = "Get All Patients REST API",
            description = "Get All Patients REST API is used to retrieve all patients from database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping
    public ResponseEntity<List<PatientDto>> findAll(){
        log.info("Patient getAll");

        List<PatientDto> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @Operation(
            summary = "Get Patient REST API",
            description = "Get Patient REST API is used to get a patient from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("{id}")
    public ResponseEntity<PatientDto> findById(@PathVariable Long id){
        log.info("Patient get: {}", id);

        PatientDto patientDto = patientService.getPatient(id);
        return new ResponseEntity<>(patientDto, HttpStatus.OK);
    }
    @Operation(
            summary = "Update Patient REST API",
            description = "Update Patient REST API is used to update patient in a database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @PutMapping("{id}")
    public ResponseEntity<PatientDto> update(
            @Valid
            @PathVariable Long id, @RequestBody PatientDto patientDto){

        log.info("Patient update: {}/{}",id, patientDto);

        patientDto.setId(id);
        PatientDto updatedPatient = patientService.updatePatient(patientDto);
        return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
    }
    @Operation(
            summary = "DELETE Patient REST API",
            description = "DELETE Patient REST API is used to delete a patient in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){

        log.info("Patient delete: {}", id);

        patientService.deletePatient(id);
        return new ResponseEntity<>("Patient Deleted Successfully!", HttpStatus.OK);
    }
    @Operation(
            summary = "Search Patient by Phone Number or Email REST API",
            description = "Search a Patient REST API is used to find patient in a database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 201 CREATED"
    )
    @GetMapping("{phoneNumberOrEmail}/search")
    public ResponseEntity<PatientDto> findByPhoneNumberOrEmail(@PathVariable String phoneNumberOrEmail){

        log.info("Patient getByPhoneOrEmail: {}", phoneNumberOrEmail);

        PatientDto patientDto = patientService.getPatientByPhoneNumberOrEmail(phoneNumberOrEmail);

        return new ResponseEntity<>(patientDto, HttpStatus.OK);
    }

    //Fallback
    public ResponseEntity<?> servicePatientFallback(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
