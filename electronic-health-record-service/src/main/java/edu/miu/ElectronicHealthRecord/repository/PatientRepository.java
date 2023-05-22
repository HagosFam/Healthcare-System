package edu.miu.ElectronicHealthRecord.repository;

import edu.miu.ElectronicHealthRecord.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
}
