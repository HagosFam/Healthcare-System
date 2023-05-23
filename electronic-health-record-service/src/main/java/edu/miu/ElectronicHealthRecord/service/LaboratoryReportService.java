package edu.miu.ElectronicHealthRecord.service;


import edu.miu.ElectronicHealthRecord.model.LaboratoryReport;
import edu.miu.ElectronicHealthRecord.model.MedicalRecord;
import edu.miu.ElectronicHealthRecord.repository.LaboratoryReportRepository;
import edu.miu.ElectronicHealthRecord.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboratoryReportService {

    private final LaboratoryReportRepository laboratoryReportRepository;
    private final MedicalRecordRepository medicalRecordRepository;
    @Autowired
    public LaboratoryReportService(LaboratoryReportRepository laboratoryReportRepository,MedicalRecordRepository medicalRecordRepository){
    this.laboratoryReportRepository = laboratoryReportRepository;
    this.medicalRecordRepository =medicalRecordRepository;
}
    public LaboratoryReport createLaboratoryReport(LaboratoryReport laboratoryReport) {
        Long patientId = laboratoryReport.getPatientId();
        MedicalRecord  medicalRecord = medicalRecordRepository.findByPatientId(patientId).orElse(null);
        if(medicalRecord != null) {
            laboratoryReport.setMedicalRecord(medicalRecord);
            LaboratoryReport savedLaboratoryReport = laboratoryReportRepository.save(laboratoryReport);
            return savedLaboratoryReport;
        }
        return null;
    }

    public LaboratoryReport getLaboratoryReportById(Long id) {
        LaboratoryReport laboratoryReport = laboratoryReportRepository.findById(id).orElse(null);
    return laboratoryReport;
    }
        public List<LaboratoryReport> getAllLaboratoryReports(Long patientId) {
            List<LaboratoryReport> list = laboratoryReportRepository.findByPatientId(patientId);
            return list;
        }
    public LaboratoryReport updateLaboratoryReport(Long laboratoryId, LaboratoryReport laboratoryReport) {
        LaboratoryReport updatelaboratoryReport = laboratoryReportRepository.getById(laboratoryId);
        if (updatelaboratoryReport.getPatientId() == laboratoryReport.getPatientId()) {
            updatelaboratoryReport.setTestResult(laboratoryReport.getTestResult());
            updatelaboratoryReport.setTestType(laboratoryReport.getTestType());
            updatelaboratoryReport.setMedicalRecord(laboratoryReport.getMedicalRecord());
            LaboratoryReport savedLaboratoryReport = laboratoryReportRepository.save(laboratoryReport);
            return savedLaboratoryReport;
        }
        return null;
    }

    public void deletePatientLaboratoryReport(Long id) {
     laboratoryReportRepository.deleteById(id);
    }
}
