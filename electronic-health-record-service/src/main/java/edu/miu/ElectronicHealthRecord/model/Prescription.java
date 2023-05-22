package edu.miu.ElectronicHealthRecord.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Prescription {
    @Id
    private Long prescriptionId;
    private Long patientId;
    private String medicationName;
    private String instruction;

}
