package edu.miu.ElectronicHealthRecord.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Patient {
    @Id
    private Long patientId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String insuranceId;
    private String email;

}
