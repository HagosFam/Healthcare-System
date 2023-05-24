package edu.miu.ElectronicHealthRecord.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LaboratoryReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long patientId;
    private String testType;
    private String testResult;
    @ManyToOne()
    private MedicalRecord medicalRecord;

}
