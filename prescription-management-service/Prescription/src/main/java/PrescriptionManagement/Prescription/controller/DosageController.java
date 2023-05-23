package PrescriptionManagement.Prescription.controller;

import PrescriptionManagement.Prescription.domain.Dosage;
import PrescriptionManagement.Prescription.proxy.Patient;
import PrescriptionManagement.Prescription.proxy.PatientErrorType;
import PrescriptionManagement.Prescription.service.DosageService;
import PrescriptionManagement.Prescription.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class DosageController {
//    @Autowired
//    DosageService dosageService;
//
//    @GetMapping("/pre/{dosageId}")
//    public ResponseEntity<?> getCar(@PathVariable long dosageId) {
//
//     Dosage patient= dosageService.getDosage(dosageId);
//        if (patient == null) {
//            return new ResponseEntity<PatientErrorType>(new PatientErrorType("Patient is not available"),
//                    HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<Dosage>(patient, HttpStatus.OK);
//    }
}
