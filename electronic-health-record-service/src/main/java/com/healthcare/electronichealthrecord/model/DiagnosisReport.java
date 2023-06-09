package com.healthcare.electronichealthrecord.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DiagnosisReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long patientId;
    private Long doctorId;
    private String diagnosisCode;
    private String recommendation;
    private Long prescriptionId; // get from other API
    @ManyToOne()
    private MedicalRecord medicalRecord;

}
