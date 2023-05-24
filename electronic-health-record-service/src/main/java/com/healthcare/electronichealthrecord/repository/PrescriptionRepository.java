package com.healthcare.electronichealthrecord.repository;

import com.healthcare.electronichealthrecord.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {

}
