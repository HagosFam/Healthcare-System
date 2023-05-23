package edu.miu.ElectronicHealthRecord.repository;

import edu.miu.ElectronicHealthRecord.model.LaboratoryReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LaboratoryReportRepository extends JpaRepository<LaboratoryReport, Long> {
    Optional<LaboratoryReport> findById(Long laboratoryReportId);
   List<LaboratoryReport> findByPatientId(Long patientId);
   LaboratoryReport getById(Long laboratoryId);
}
