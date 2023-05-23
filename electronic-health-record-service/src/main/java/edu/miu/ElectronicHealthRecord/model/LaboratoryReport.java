package edu.miu.ElectronicHealthRecord.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonIgnore
    private MedicalRecord medicalRecord;

}
