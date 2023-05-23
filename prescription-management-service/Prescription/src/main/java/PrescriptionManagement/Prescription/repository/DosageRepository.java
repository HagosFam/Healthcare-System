package PrescriptionManagement.Prescription.repository;


import PrescriptionManagement.Prescription.domain.Dosage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DosageRepository extends JpaRepository<Dosage, Long> {
}
