package PrescriptionManagement.Prescription.repository;


import PrescriptionManagement.Prescription.domain.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {

  //  List<Medication> findbyMedicationId(long medicationId);
}
