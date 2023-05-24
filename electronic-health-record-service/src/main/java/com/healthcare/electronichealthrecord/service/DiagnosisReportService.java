package com.healthcare.electronichealthrecord.service;

import com.healthcare.electronichealthrecord.model.MedicalRecord;
import com.healthcare.electronichealthrecord.model.DiagnosisReport;
import com.healthcare.electronichealthrecord.model.Prescription;
import com.healthcare.electronichealthrecord.repository.DiagnosisReportRepository;
import com.healthcare.electronichealthrecord.repository.MedicalRecordRepository;
import com.healthcare.electronichealthrecord.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;


@Service
public class DiagnosisReportService {
    RestTemplate restTemplate = new RestTemplate();
    private final DiagnosisReportRepository diagnosisReportRepository;
    private final PrescriptionRepository prescriptionRepository;
    @Autowired
    public  DiagnosisReportService(DiagnosisReportRepository diagnosisReportRepository,PrescriptionRepository prescriptionRepository,
                                   MedicalRecordRepository medicalRecordRepository){
        this.diagnosisReportRepository = diagnosisReportRepository;
        this.prescriptionRepository = prescriptionRepository;
        this.medicalRecordRepository = medicalRecordRepository;
    }


    final String url = "http://localhost:8088/prescription/";
    private final MedicalRecordRepository medicalRecordRepository;

    //post
    public DiagnosisReport createDiagnosisReport(DiagnosisReport diagnosisReport){
        Prescription prescription = restTemplate.getForObject(url + diagnosisReport.getPrescriptionId(), Prescription.class);
        prescriptionRepository.save(prescription);
        Long patientId = diagnosisReport.getPatientId();
        MedicalRecord medicalRecord = medicalRecordRepository.getReferenceById(patientId);
        diagnosisReport.setMedicalRecord(medicalRecord);
        DiagnosisReport savedDiagnosisReport = diagnosisReportRepository.save(diagnosisReport);

        return savedDiagnosisReport;
    }
    public DiagnosisReport getDiagnosisReportById(Long id) {
        return diagnosisReportRepository.getReferenceById(id);
    }

    public List<DiagnosisReport> getAllDiagnosisReports(Long medicalRecordId) {
        List<DiagnosisReport> list = diagnosisReportRepository.findByMedicalRecordId(medicalRecordId);
        return list;
    }
    public DiagnosisReport updateDiagnosisReport(Long diagnosisId , DiagnosisReport updateDiagnosisReport) {

        DiagnosisReport diagnosisReport = diagnosisReportRepository.getById(diagnosisId);
        Long patientId = diagnosisReport.getPatientId();
        MedicalRecord medicalRecord = medicalRecordRepository.getReferenceById(patientId);

        diagnosisReport.setPatientId(patientId);
        diagnosisReport.setMedicalRecord(medicalRecord);;
        diagnosisReport.setDiagnosisCode(updateDiagnosisReport.getDiagnosisCode());
        diagnosisReport.setPrescriptionId(updateDiagnosisReport.getPrescriptionId());
        diagnosisReport.setRecommendation(updateDiagnosisReport.getRecommendation());
        diagnosisReport.setDoctorId(updateDiagnosisReport.getDoctorId());

        return diagnosisReportRepository.save(diagnosisReport);
    }
    public void deleteDiagnosisReport(Long id) {
        diagnosisReportRepository.deleteById(id);
    }
}
