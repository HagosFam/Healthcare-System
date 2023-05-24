package com.healthcare.electronichealthrecord.controller;

import com.healthcare.electronichealthrecord.model.MedicalRecord;
import com.healthcare.electronichealthrecord.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value="/api/v1/medicalrecord")
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;
    @Autowired
    public MedicalRecordController(MedicalRecordService medicalRecordService){
        this.medicalRecordService= medicalRecordService;
    }

    @GetMapping("/{medicalRecordId}")
    public ResponseEntity<?> getMedicalRecord(@PathVariable Long medicalRecordId){
       MedicalRecord medicalRecordDto = medicalRecordService.findMedicalRecordById(medicalRecordId);
       if(medicalRecordDto != null){
           ResponseEntity<MedicalRecord> response = new ResponseEntity<>(medicalRecordDto, HttpStatus.OK);
           return response;
       }
       String message ="Medical record does not exist";
       ResponseEntity<String> response = new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
       return response;
    }
    @GetMapping("/")
    public ResponseEntity<?> getAllMedicalRecords(){
     List<MedicalRecord> medicalRecordList = medicalRecordService.findAllMedicalRecords();
     if(medicalRecordList != null) {
         ResponseEntity<List<MedicalRecord>> response = new ResponseEntity<>(medicalRecordList, HttpStatus.OK);
         return response;
     }
         String message = "Medical Record has no content, its empty";
         return ResponseEntity.status(HttpStatus.NO_CONTENT).body(message);
     }
    @GetMapping("/allergy/{medicalRecordId}")
    public ResponseEntity<?> getPatientAllergyList(@PathVariable Long medicalRecordId) {
        if (medicalRecordService.findMedicalRecordById(medicalRecordId) != null) {
            Set<String> allergyList = medicalRecordService.getAllergyList(medicalRecordId);
            return ResponseEntity.ok().body(allergyList);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                body("There is no medical record with ID " + medicalRecordId);
    }
    @PostMapping("/")
    public ResponseEntity<?> createMedicalRecord(@RequestParam Long patientId){
        MedicalRecord medicalRecordDto = medicalRecordService.createMedicalRecordByPatientId(patientId);
        if(medicalRecordDto == null) {
            String message = "Medical Record Already Exists for patient with ID" + patientId;
            ResponseEntity<String> response = new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
            return response;
        }
        if(medicalRecordDto != null){
            ResponseEntity<MedicalRecord> response = new ResponseEntity<>(medicalRecordDto, HttpStatus.CREATED);
            return response;
        }
        else
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create medical record");
    }
    @PostMapping("/allergy/{medicalRecordId}")
    public ResponseEntity<?> addPatientAllergy(@PathVariable Long medicalRecordId,@RequestParam String allergy){
        Set<String> allergies = medicalRecordService.addAllergy(medicalRecordId,allergy);
        if(allergies.contains(allergy))
            return ResponseEntity.ok().body(allergies);
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add the requested allergy");

    }

    @PatchMapping("/{medicalRecordId}")
    public ResponseEntity<?> updatePatientId(@PathVariable Long medicalRecordId, @RequestParam Long patientId){
        MedicalRecord medicalRecord = medicalRecordService.editMedicalRecordPatientId(medicalRecordId,patientId);
        if(medicalRecordService.findMedicalRecordById(medicalRecordId).getPatientId() == patientId){
            return ResponseEntity.ok().body(medicalRecord);
        }
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("PatientId update failed");
    }

    @DeleteMapping("/{medicalRecordId}")
    public ResponseEntity<String> deletePatientMedicalRecord(@PathVariable Long medicalRecordId){
        if(medicalRecordService.findMedicalRecordById(medicalRecordId) != null) {
            medicalRecordService.deleteMedicalRecordById(medicalRecordId);
            if(medicalRecordService.findMedicalRecordById(medicalRecordId) == null){
                return ResponseEntity.ok().body("Medical record deleted from the system");
            }
            else
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File deletion failed");
        }
        return ResponseEntity.
                status(HttpStatus.BAD_REQUEST).
                body("the requested medical record with Id " + medicalRecordId + " is not in the system");
    }
    @DeleteMapping("/allergy/{medicalRecordId}")
    public ResponseEntity<String> deleteAllergy(@PathVariable Long medicalRecordId, @RequestParam String allergy){
        medicalRecordService.deleteSpecificAllergy(medicalRecordId,allergy);
        if(!medicalRecordService.getAllergyList(medicalRecordId).contains(allergy))
            return ResponseEntity.ok().body("Requested Allergy was deleted");
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete the requested allergy");
}


}
