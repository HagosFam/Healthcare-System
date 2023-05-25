package com.healthcare.prescriptionmanagement.controller;

import com.healthcare.prescriptionmanagement.domain.*;
import com.healthcare.prescriptionmanagement.repository.MedicationRepository;
import com.healthcare.prescriptionmanagement.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/prescriptions")
@CrossOrigin("*")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired
    private MedicationRepository medicationRepository;



    @PostMapping("/writemed")
    public ResponseEntity<?> prescriptionOperation (@RequestBody Medication medication ) {


        long idmed= prescriptionService.WriteMedication(medication);

        return new ResponseEntity<Long>(idmed, HttpStatus.OK);

    }
    @PostMapping("/addosage")
    public ResponseEntity<?> prescriptionAddDosage (
            @RequestParam(value="medicationId")long medicationId,
            @RequestBody Dosage dosage ) {


        long id= prescriptionService.addDoseForMedication(medicationId,dosage);
        return new ResponseEntity<Long>(id, HttpStatus.OK);
    }
    @PostMapping("/createprescription")
    public ResponseEntity<?>  creatPrescription (   @RequestParam(value="patientId")long patientId,
                                                    @RequestParam(value="medicationId")long medicationId,
                                                    @RequestParam(value="status")PrescriptionStatus status) {


        Prescription prescription= prescriptionService.createPrescription(patientId,medicationId,status);

        return new ResponseEntity<Prescription>(prescription, HttpStatus.OK);

    }



    @GetMapping("{prescriptionId}")
    public ResponseEntity<?> getPrescription(@PathVariable long prescriptionId) {

        Prescription prescription = prescriptionService.ViewPrescription(prescriptionId);
        if (prescription == null) {
            return new ResponseEntity<PrescriptionErrorType>(new PrescriptionErrorType("Prescription is not available"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Prescription>(prescription, HttpStatus.OK);
    }

    @GetMapping("{patientId}")
    public ResponseEntity<?> getPrescriptionByPatientId(@PathVariable long patientId) {

        Prescription prescription = prescriptionService.ViewPrescrptionForPatient(patientId);
        if (prescription == null) {
            return new ResponseEntity<PrescriptionErrorType>(new PrescriptionErrorType("Prescription is not available"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Prescription>(prescription, HttpStatus.OK);
    }

    @DeleteMapping("{prescriptionId}")
    public ResponseEntity<?> deletePatient(@PathVariable long prescriptionId) {
        Prescription prescription = prescriptionService.ViewPrescription(prescriptionId);
        if (prescription == null) {
            return new ResponseEntity<PrescriptionErrorType>(new PrescriptionErrorType("Prescription is not available"),
                    HttpStatus.NOT_FOUND);
        }
        prescriptionService.DeletePrescription(prescriptionId);
        return new ResponseEntity<Prescription>(prescription, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllPrescriptions() {
        List<Prescription> prescriptionList = prescriptionService.getAllPrescriptions();
        Prescriptions prescriptions = new Prescriptions();
        prescriptions.setPrescriptions(prescriptionList);
        return new ResponseEntity<Prescriptions>(prescriptions, HttpStatus.OK);
    }
}