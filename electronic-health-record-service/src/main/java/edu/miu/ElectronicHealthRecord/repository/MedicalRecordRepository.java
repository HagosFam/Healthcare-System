package edu.miu.ElectronicHealthRecord.repository;

import edu.miu.ElectronicHealthRecord.model.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
    Optional<MedicalRecord> findByPatientId(Long patientId);
}