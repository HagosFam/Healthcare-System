package com.healthcare.electronichealthrecord.controller;

import com.healthcare.electronichealthrecord.service.LaboratoryReportService;
import com.healthcare.electronichealthrecord.model.LaboratoryReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value ="/api/v1/medicalrecord/laboratory")
public class LaboratoryReportController {
    private final LaboratoryReportService laboratoryReportService;
    @Autowired
    public LaboratoryReportController (LaboratoryReportService laboratoryReportService){
        this.laboratoryReportService = laboratoryReportService;
    }

    @GetMapping("/{laboratoryId}")
    public ResponseEntity<?> getPatientLaboratory(@PathVariable Long laboratoryId){
        LaboratoryReport laboratoryReportDto  = laboratoryReportService.getLaboratoryReportById(laboratoryId);
        if(laboratoryReportDto != null){
            return ResponseEntity.ok().body(laboratoryReportDto);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).
                body("Laboratory report with ID" + laboratoryId +"does not exist");
    }

    @GetMapping("/{medicalRecordId}")
    public ResponseEntity<?> getPatientDiagnosisList(@PathVariable Long medicalRecordId){
        List<LaboratoryReport> laboratoryReport  = laboratoryReportService.getAllLaboratoryReports(medicalRecordId);
        if(laboratoryReport != null){
            return ResponseEntity.ok().body(laboratoryReport);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).
                body("Laboratory report with medicalRecord ID" + medicalRecordId +"has no laboratory report");
    }

    @PostMapping("/")
    public ResponseEntity<?> createPatientLaboratoryReport(@RequestBody LaboratoryReport laboratoryReport){
        Long patientId = laboratoryReport.getPatientId();
        LaboratoryReport newLaboratoryReport = laboratoryReportService.createLaboratoryReport(laboratoryReport);
        if(laboratoryReportService.getAllLaboratoryReports(patientId).contains(newLaboratoryReport)){
            return ResponseEntity.ok().body(newLaboratoryReport);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("laboratory report has not been saved");
    }

    @PutMapping("/{laboratoryId}")
    public ResponseEntity<?> updatePatientDiagnosis(@PathVariable Long laboratoryId , @RequestBody LaboratoryReport laboratoryReport){
        LaboratoryReport newlaboratoryReportDto = laboratoryReportService.updateLaboratoryReport(laboratoryId,laboratoryReport);
        if(laboratoryReportService.getLaboratoryReportById(laboratoryId) == newlaboratoryReportDto){
            return ResponseEntity.ok().body(newlaboratoryReportDto);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update the laboratory report");
    }

    @DeleteMapping("/{laboratoryId}")
    public ResponseEntity<String> deletePatientLaboratoryReport(@PathVariable Long laboratoryId){
        laboratoryReportService.deletePatientLaboratoryReport(laboratoryId);
        if(laboratoryReportService.getLaboratoryReportById(laboratoryId) == null){
            return ResponseEntity.ok().body("Laboratory report with ID" + laboratoryId + " is deleted");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete the laboratory report");
    }
}
