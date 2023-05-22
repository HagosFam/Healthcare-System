package edu.miu.ElectronicHealthRecord.repository;

import edu.miu.ElectronicHealthRecord.model.LaboratoryReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LaboratoryReportRepository extends JpaRepository<LaboratoryReport, Long> {
    List<LaboratoryReport> findByMedicalRecordId(Long medicalRecordId);
}
