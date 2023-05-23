package PrescriptionManagement.Prescription.repository;

import PrescriptionManagement.Prescription.domain.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    Prescription findByPatientId(long patientId);


}
