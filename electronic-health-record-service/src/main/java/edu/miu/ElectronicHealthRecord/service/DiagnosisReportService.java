package edu.miu.ElectronicHealthRecord.service;

import edu.miu.ElectronicHealthRecord.model.DiagnosisReport;
import edu.miu.ElectronicHealthRecord.model.MedicalRecord;
import edu.miu.ElectronicHealthRecord.model.Prescription;
import edu.miu.ElectronicHealthRecord.repository.DiagnosisReportRepository;
import edu.miu.ElectronicHealthRecord.repository.MedicalRecordRepository;
import edu.miu.ElectronicHealthRecord.repository.PrescriptionRepository;
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

    /** for simulation to check the handshake only **/
    final String url = "http://localhost:8088/prescription/";
    private final MedicalRecordRepository medicalRecordRepository;

    public DiagnosisReport createDiagnosisReport(DiagnosisReport diagnosisReport){
        Prescription prescription = restTemplate.getForObject(url + diagnosisReport.getPrescriptionId(), Prescription.class);
        prescriptionRepository.save(prescription);

        Long patientId = diagnosisReport.getPatientId();
        MedicalRecord medicalRecord = medicalRecordRepository.findByPatientId(patientId).orElse(null);
        if(medicalRecord!=null) {
            diagnosisReport.setMedicalRecord(medicalRecord);
            DiagnosisReport savedDiagnosisReport = diagnosisReportRepository.save(diagnosisReport);
            return savedDiagnosisReport;
        }
        return null;
    }
    public DiagnosisReport getDiagnosisReportById(Long id) {

         DiagnosisReport diagnosisReport = diagnosisReportRepository.findById(id).orElse(null);
         return diagnosisReport;
    }

    public List<DiagnosisReport> getAllDiagnosisReports(Long patientId) {
        List<DiagnosisReport> list = diagnosisReportRepository.findByPatientId(patientId);
        return list;
    }
    public DiagnosisReport updateDiagnosisReport(Long diagnosisId , DiagnosisReport diagnosisReport) {

        DiagnosisReport updateDiagnosisReport = diagnosisReportRepository.findById(diagnosisId).orElse(null);
        Long patientId_1 = diagnosisReport.getPatientId();
        Long patientId_2 =updateDiagnosisReport.getPatientId();

if(patientId_2 == patientId_1) {
    updateDiagnosisReport.setDiagnosisCode(diagnosisReport.getDiagnosisCode());
    updateDiagnosisReport.setPrescriptionId(diagnosisReport.getPrescriptionId());
    updateDiagnosisReport.setRecommendation(diagnosisReport.getRecommendation());
    updateDiagnosisReport.setDoctorId(diagnosisReport.getDoctorId());
    return diagnosisReportRepository.save(updateDiagnosisReport);

}
return null;
    }
    public void deleteDiagnosisReport(Long id) {
        diagnosisReportRepository.deleteById(id);
    }
}
