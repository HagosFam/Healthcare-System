package edu.miu.ElectronicHealthRecord.repository;

import edu.miu.ElectronicHealthRecord.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {

}
