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
       // LaboratoryReport laboratoryReport = LaboratoryReportDtoAdapter.fromDto(laboratoryReportDto);
        Long patientId = laboratoryReport.getPatientId();
        MedicalRecord medicalRecord = medicalRecordRepository.getReferenceById(patientId);
        laboratoryReport.setMedicalRecord(medicalRecord);
        LaboratoryReport savedLaboratoryReport = laboratoryReportRepository.save(laboratoryReport);
        return savedLaboratoryReport;
    }

    public LaboratoryReport getLaboratoryReportById(Long id) {
        LaboratoryReport laboratoryReport = laboratoryReportRepository.getReferenceById(id);
    return laboratoryReport;
    }

    public List<LaboratoryReport> getAllLaboratoryReports(Long medicalRecordId) {
      List<LaboratoryReport> laboratoryReportList =  laboratoryReportRepository.findByMedicalRecordId(medicalRecordId);
    return laboratoryReportList;
    }

    public LaboratoryReport updateLaboratoryReport(Long laboratoryId, LaboratoryReport laboratoryReportDto) {
        LaboratoryReport laboratoryReport = laboratoryReportRepository.getById(laboratoryId);
        laboratoryReport.setTestResult(laboratoryReportDto.getTestResult());
        laboratoryReport.setTestType(laboratoryReportDto.getTestType());
        //laboratoryReport.setMedicalRecord(MedicalRecordDtoAdapter.fromDto(laboratoryReportDto.getMedicalRecord()));
        LaboratoryReport savedLaboratoryReport = laboratoryReportRepository.save(laboratoryReport);
          return savedLaboratoryReport;
    }

    public void deletePatientLaboratoryReport(Long id) {
     laboratoryReportRepository.deleteById(id);
    }
}
