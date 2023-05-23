package edu.miu.ElectronicHealthRecord.repository;

import edu.miu.ElectronicHealthRecord.model.DiagnosisReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DiagnosisReportRepository extends JpaRepository<DiagnosisReport, Long> {
    List<DiagnosisReport> findByPatientId(Long patientId);
    Optional<DiagnosisReport> findById(Long diagnosisId);

}
