package edu.miu.ElectronicHealthRecord.controller;

import edu.miu.ElectronicHealthRecord.model.LaboratoryReport;
import edu.miu.ElectronicHealthRecord.service.LaboratoryReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/medicalRecord/laboratory")
public class LaboratoryReportController {
    private final LaboratoryReportService laboratoryReportService;
    @Autowired
    public LaboratoryReportController (LaboratoryReportService laboratoryReportService){
        this.laboratoryReportService = laboratoryReportService;
    }

    @GetMapping("/{laboratoryId}")
    public ResponseEntity<?> getPatientLaboratory(@PathVariable Long laboratoryId){
        LaboratoryReport laboratoryReport  = laboratoryReportService.getLaboratoryReportById(laboratoryId);
        if(laboratoryReport != null){
            return ResponseEntity.ok().body(laboratoryReport);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).
                body("Laboratory report with ID " + laboratoryId + " does not exist");
    }

    @GetMapping("/list/{patientId}")
    public ResponseEntity<?> getPatientLaboratoryList(@PathVariable Long patientId){
        List<LaboratoryReport> laboratoryReports  = laboratoryReportService.getAllLaboratoryReports(patientId);
        if(laboratoryReports != null){
            return ResponseEntity.ok().body(laboratoryReports);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Laboratory report with medicalRecord ID" + patientId +"has no laboratory report");
    }

    @PostMapping("")
    public ResponseEntity<?> createPatientLaboratoryReport(@RequestBody LaboratoryReport laboratoryReport){
        Long patientId = laboratoryReport.getPatientId();
        LaboratoryReport newLaboratoryReport = laboratoryReportService.createLaboratoryReport(laboratoryReport);
        if(laboratoryReportService.getAllLaboratoryReports(patientId).contains(newLaboratoryReport)){
            return ResponseEntity.ok().body(newLaboratoryReport);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("laboratory report has not been saved");
    }

    @PutMapping("/{laboratoryId}")
    public ResponseEntity<?> updatePatientLaboratory(@PathVariable Long laboratoryId , @RequestBody LaboratoryReport laboratoryReport){
        LaboratoryReport newlaboratoryReport = laboratoryReportService.updateLaboratoryReport(laboratoryId,laboratoryReport);
        if(newlaboratoryReport != null){
            return ResponseEntity.ok().body(newlaboratoryReport);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Failed to update the laboratory report");
    }

    @DeleteMapping("/{laboratoryId}")
    public ResponseEntity<String> deletePatientLaboratoryReport(@PathVariable Long laboratoryId){
        laboratoryReportService.deletePatientLaboratoryReport(laboratoryId);
        if(laboratoryReportService.getLaboratoryReportById(laboratoryId) == null){
            return ResponseEntity.ok().body("Laboratory report with ID " + laboratoryId + " is deleted");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete the laboratory report");
    }
}
