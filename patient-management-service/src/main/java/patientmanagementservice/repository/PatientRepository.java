package patientmanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import patientmanagementservice.dto.PatientDto;
import patientmanagementservice.entity.Patient;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> getPatientByPhoneNumberOrEmail(String phoneNumber, String email);
    Optional<Patient> getPatientByPhoneNumber(String phoneNumner);
    Optional<Patient> getPatientByEmail(String email);
}
