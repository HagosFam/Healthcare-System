package PrescriptionManagement.Prescription.controller;

import PrescriptionManagement.Prescription.domain.*;
import PrescriptionManagement.Prescription.proxy.Patient;
import PrescriptionManagement.Prescription.proxy.PatientErrorType;
import PrescriptionManagement.Prescription.repository.MedicationRepository;
import PrescriptionManagement.Prescription.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired
    private MedicationRepository medicationRepository;

    @PostMapping("/createprescription")
    public ResponseEntity<?> createPrescription(@RequestParam(value= "patientId") long patientId,
                                                @RequestParam(value= "medicationId") long medicationId, @RequestParam(value= "status")PrescriptionStatus status) {
        Prescription prescription = prescriptionService.createPrescription(patientId,medicationId,status);
        return new ResponseEntity<Prescription>(prescription, HttpStatus.OK);
    }


    @GetMapping("/prescription/prescriptionId/{prescriptionId}")
    public ResponseEntity<?> getPrescription(@PathVariable long prescriptionId) {

      Prescription prescription= prescriptionService.ViewPrescription(prescriptionId);
        if (prescription == null) {
            return new ResponseEntity<PrescriptionErrorType>(new PrescriptionErrorType("Prescription is not available"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Prescription>(prescription, HttpStatus.OK);
    }
    @GetMapping("/prescription/patientId/{patientId}")
    public ResponseEntity<?> getPrescriptionByPatientId(@PathVariable long patientId) {

        Prescription prescription= prescriptionService.ViewPrescrptionForPatient(patientId);
        if (prescription == null) {
            return new ResponseEntity<PrescriptionErrorType>(new PrescriptionErrorType("Prescription is not available"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Prescription>(prescription, HttpStatus.OK);
    }

    @DeleteMapping("/prescription/{prescriptionId}")
    public ResponseEntity<?> deletePatient(@PathVariable long prescriptionId) {
        Prescription prescription= prescriptionService.ViewPrescription(prescriptionId);
        if (prescription == null) {
            return new ResponseEntity<PrescriptionErrorType>(new PrescriptionErrorType("Prescription is not available"),
                    HttpStatus.NOT_FOUND);
        }
        prescriptionService.DeletePrescription(prescriptionId);
        return new ResponseEntity<Prescription>(prescription, HttpStatus.OK);
    }

    @GetMapping("/prescriptions")
    public ResponseEntity<?> getAllPrescriptions() {
        List<Prescription> prescriptionList = prescriptionService.getAllPrescriptions();
        Prescriptions prescriptions=new Prescriptions();
        prescriptions.setPrescriptions(prescriptionList);
        return new ResponseEntity<Prescriptions>(prescriptions, HttpStatus.OK);
    }










































    @PostMapping("/prop")
    public void prescriptionOperation (@RequestBody Medication medication) {

//        @RequestParam(value="medicationName")String medicationName,
//        @RequestParam(value="description")String description,
//        @RequestParam(value="manufacture")String manufacture
//        @PostMapping("/prop")
//        public Medication prescriptionOperation (@RequestBody Medication medication
//
//
//                                      ) {
//            // @RequestParam(value="description")String description,
//            // @RequestParam(value="manufacture")String manufacture
//            //if (operation. equals("medic")) {
//            prescriptionService.addmedication(medication);
//            return medication;
//            //       return prescriptionService.getmed(id);
//            //  }
//            // return null;
//            //  if (operation. equals("addose")) prescriptionService.addDoseForMedication(medicationId,dosage);
//            // if (operation. equals("creatp")) prescriptionService.createPrescription(patientId,medicationId,status);
//
//
//        }
        //if (operation. equals("medic")) {
      //  long id = prescriptionService.WriteMedication(medication);
        //    medicationRepository.

     ////   Medication p=  medicationRepository.findById(id).get();
      //  medicationRepository.save(p);
        //  }
        // return null;
        //  if (operation. equals("addose")) prescriptionService.addDoseForMedication(medicationId,dosage);
        // if (operation. equals("creatp")) prescriptionService.createPrescription(patientId,medicationId,status);


    }
}
