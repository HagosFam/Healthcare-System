package PrescriptionManagement.Prescription.controller;

import PrescriptionManagement.Prescription.domain.*;
import PrescriptionManagement.Prescription.proxy.Patient;
import PrescriptionManagement.Prescription.proxy.PatientErrorType;
import PrescriptionManagement.Prescription.repository.MedicationRepository;
import PrescriptionManagement.Prescription.service.DosageDTO;
import PrescriptionManagement.Prescription.service.MedicationDTO;
import PrescriptionManagement.Prescription.service.PrescriptionDTO;
import PrescriptionManagement.Prescription.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/prescription")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired
    private MedicationRepository medicationRepository;


    @PostMapping("/prop")
    public void prescriptionOperation ( @RequestParam(value= "operation") String operation,
                                        @RequestParam(value="patientId")long patientId,
                                        @RequestParam(value="medicationId")long medicationId,
                                        @RequestParam(value="status")PrescriptionStatus status,
                                        @RequestBody DosageDTO dosage,
                                        @RequestBody MedicationDTO medication ) {

        if (operation. equals("writemed"))prescriptionService.WriteMedication(medication);
        if (operation. equals("addose"))prescriptionService.addDoseForMedication(medicationId,dosage);
        if (operation. equals("creatpres"))prescriptionService.createPrescription(patientId,medicationId,status);

    }

//DONE DTO   start here
    @GetMapping("/prescriptionId/{prescriptionId}")
    public ResponseEntity<?> getPrescription(@PathVariable long prescriptionId) {

     PrescriptionDTO prescription= prescriptionService.ViewPrescription(prescriptionId);
        if (prescription == null) {
            return new ResponseEntity<PrescriptionErrorType>(new PrescriptionErrorType("Prescription is not available"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PrescriptionDTO>(prescription, HttpStatus.OK);
    }
//    //DONE DTO
    @GetMapping("/patientId/{patientId}")
    public ResponseEntity<?> getPrescriptionByPatientId(@PathVariable long patientId) {
       // PrescriptionDTO prescription= prescriptionService.ViewPrescription(prescriptionId);
        PrescriptionDTO prescription= prescriptionService.ViewPrescrptionForPatient(patientId);
        if (prescription == null) {
            return new ResponseEntity<PrescriptionErrorType>(new PrescriptionErrorType("Prescription is not available"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PrescriptionDTO>(prescription, HttpStatus.OK);
    }

    @DeleteMapping("/prescription/{prescriptionId}")
    public ResponseEntity<?> deletePatient(@PathVariable long prescriptionId) {
        PrescriptionDTO prescription= prescriptionService.ViewPrescription(prescriptionId);
        if (prescription == null) {
            return new ResponseEntity<PrescriptionErrorType>(new PrescriptionErrorType("Prescription is not available"),
                    HttpStatus.NOT_FOUND);
        }
        prescriptionService.DeletePrescription(prescriptionId);
        return new ResponseEntity<PrescriptionDTO>(prescription, HttpStatus.OK);
    }

    @GetMapping("/prescriptions")
    public ResponseEntity<?> getAllPrescriptions() {
        List<PrescriptionDTO> prescriptionList = prescriptionService.getAllPrescriptions();
        Prescriptions prescriptions = new Prescriptions();
        prescriptions.setPrescriptions(prescriptionList);
        return new ResponseEntity<Prescriptions>(prescriptions, HttpStatus.OK);
    }

}
