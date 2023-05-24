package edu.miu.ElectronicHealthRecord.repository;

import edu.miu.ElectronicHealthRecord.model.DiagnosisReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiagnosisReportRepository extends JpaRepository<DiagnosisReport, Long> {
    List<DiagnosisReport> findByMedicalRecordId(Long medicalRecordId);
}
