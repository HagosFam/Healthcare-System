package com.healthcare.patientmanagement.controller;

import com.healthcare.patientmanagement.dto.PatientDto;
import com.healthcare.patientmanagement.service.PatientService;
import com.healthcare.patientmanagement.util.FeignIdentityManagementServiceUtil;
import com.healthcare.patientmanagement.util.Role;
import com.healthcare.patientmanagement.util.User;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class PatientController {

    private static final String SERVICE_PATIENT = "servicePatient";

    private PatientService patientService;

    private FeignIdentityManagementServiceUtil identityManagementServiceUtil;

    private static final Logger logger = LoggerFactory.getLogger(PatientController.class);

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

        logger.info("Patient create: {}", patientDto);

        PatientDto patient = patientService.createPatient(patientDto);

        User user = new User(
                patient.getEmail(),
                patient.getFirstName(),
                patient.getLastName(),
                "1234",
                Role.PATIENT
        );
        identityManagementServiceUtil.save(user);

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
    public ResponseEntity<List<PatientDto>> getAll(){
        logger.info("Patient getAll");

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
    public ResponseEntity<PatientDto> get(@PathVariable Long id){
        logger.info("Patient get: {}", id);

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

        logger.info("Patient update: {}/{}",id, patientDto);

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

        logger.info("Patient delete: {}", id);

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
    public ResponseEntity<PatientDto> getByPhoneNumberOrEmail(@PathVariable String phoneNumberOrEmail){

        logger.info("Patient getByPhoneOrEmail: {}", phoneNumberOrEmail);

        PatientDto patientDto = patientService.getPatientByPhoneNumberOrEmail(phoneNumberOrEmail);

        return new ResponseEntity<>(patientDto, HttpStatus.OK);
    }

    //Fallback
    public ResponseEntity<?> servicePatientFallback(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
