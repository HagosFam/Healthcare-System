package com.healthcare.electronichealthrecord.controller;


import com.healthcare.electronichealthrecord.model.DiagnosisReport;
import com.healthcare.electronichealthrecord.service.DiagnosisReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medicalrecord/diagnosis")
public class DiagnosisController {
   private final  DiagnosisReportService diagnosisReportService;
    @Autowired
   public DiagnosisController (DiagnosisReportService diagnosisReportService){
        this.diagnosisReportService = diagnosisReportService;
    }

    @GetMapping("/{diagnosisId}")
    public ResponseEntity<?> getPatientDiagnosis(@PathVariable Long diagnosisId){
        DiagnosisReport diagnosisReport  = diagnosisReportService.getDiagnosisReportById(diagnosisId);
        if(diagnosisReport != null){
            return ResponseEntity.ok().body(diagnosisReport);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Diagnosis report with diagnosis ID" + diagnosisId +"does not exist");
    }

    @GetMapping("list/{medicalRecordId}")
    public ResponseEntity<?> getPatientDiagnosisList(@PathVariable Long medicalRecordId){
        List<DiagnosisReport> diagnosisReports  = diagnosisReportService.getAllDiagnosisReports(medicalRecordId);
        if(diagnosisReports != null){
            return ResponseEntity.ok().body(diagnosisReports);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Diagnosis report with medicalRecord ID" + medicalRecordId +"has no diagnosis report");
    }

    @PostMapping("/")
    public ResponseEntity<?> createPatientDiagnosis(@RequestBody DiagnosisReport diagnosis){
        Long patientId = diagnosis.getPatientId();
        DiagnosisReport newDiagnosisReport = diagnosisReportService.createDiagnosisReport(diagnosis);
        if(diagnosisReportService.getAllDiagnosisReports(patientId).contains(newDiagnosisReport)){
            return ResponseEntity.ok().body(newDiagnosisReport);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Diagnosis report has not been saved");
    }

    @PutMapping("/{diagnosisId}")
    public ResponseEntity<?> updatePatientDiagnosis(@PathVariable Long diagnosisId , @RequestBody DiagnosisReport diagnosis){
        DiagnosisReport diagnosisReport = diagnosisReportService.updateDiagnosisReport(diagnosisId,diagnosis);
        if(diagnosisReportService.getDiagnosisReportById(diagnosis.getId()) == diagnosis){
            return ResponseEntity.ok().body(diagnosisReport);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update the diagnosis report");
    }

    @DeleteMapping("/{diagnosisId}")
    public ResponseEntity<String> deletePatientDiagnosis(@PathVariable Long diagnosisId){
        diagnosisReportService.deleteDiagnosisReport(diagnosisId);
        if(diagnosisReportService.getDiagnosisReportById(diagnosisId) == null){
            return ResponseEntity.ok().body("Diagnosis report with ID" + diagnosisId + " is deleted");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete the diagnosis report");
    }
}
