package edu.miu.ElectronicHealthRecord.controller;

import edu.miu.ElectronicHealthRecord.model.MedicalRecord;
import edu.miu.ElectronicHealthRecord.repository.PatientRepository;
import edu.miu.ElectronicHealthRecord.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value="/medicalRecord")
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;
    private final PatientRepository patientRepository;
    @Autowired
    public MedicalRecordController(MedicalRecordService medicalRecordService, PatientRepository patientRepository){
        this.medicalRecordService= medicalRecordService;
        this.patientRepository = patientRepository;
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
    @PostMapping("/{patientId}")
    public ResponseEntity<?> createMedicalRecord(@PathVariable Long patientId){
        MedicalRecord newMedicalRecord = medicalRecordService.createMedicalRecord(patientId);
        if(newMedicalRecord == null && patientRepository.findByPatientId(patientId).isPresent()) {
            String message = "The patient with ID " + patientId + " , has been registered before" ;
            ResponseEntity<String> response = new ResponseEntity<>(message, HttpStatus.FORBIDDEN);
            return response;
        }
        if(newMedicalRecord == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The patient requested is not registered,yet.");

        ResponseEntity<MedicalRecord> response = new ResponseEntity<>(newMedicalRecord, HttpStatus.CREATED);
        return response;
    }

    @PostMapping("/allergy/{medicalRecordId}")
    public ResponseEntity<?> addPatientAllergy(@PathVariable Long medicalRecordId,@RequestBody List<String> allergy){
        Set<String> allergies = medicalRecordService.addAllergy(medicalRecordId,allergy);
       int count=0;
       for(String element: allergy){
          if(allergies.contains(element));
             count++;
       }
        if(count == allergy.size())
            return ResponseEntity.ok().body(allergies);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Failed to add the requested allergy");

    }

    @PutMapping("/{medicalRecordId}")
    public ResponseEntity<?> updateMedicalRecord(@PathVariable Long medicalRecordId, @RequestBody MedicalRecord medicalRecord){
        MedicalRecord newMedicalRecord = medicalRecordService.updateMedicalRecord(medicalRecordId,medicalRecord);
        if(medicalRecordService.findMedicalRecordById(medicalRecordId) == newMedicalRecord) {
            return ResponseEntity.ok().body(newMedicalRecord);
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
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File has not been deleted");
        }
        return ResponseEntity.
                status(HttpStatus.BAD_REQUEST).
                body("the requested medical record with Id " + medicalRecordId + " is not in the system");
    }
    @DeleteMapping("/allergy/{medicalRecordId}")
    public ResponseEntity<String> deleteAllergy(@PathVariable Long medicalRecordId){
        medicalRecordService.deleteAllergy(medicalRecordId);
        if(medicalRecordService.getAllergyList(medicalRecordId).isEmpty())
            return ResponseEntity.ok().body("Requested Allergy was deleted");
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Failed to delete the requested allergy");
}


}
