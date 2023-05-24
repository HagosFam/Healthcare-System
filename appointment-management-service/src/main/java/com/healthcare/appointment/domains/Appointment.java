package com.healthcare.appointment.domains;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue
    private Long appointmentId;
    private Long patientId;
    private String appointmentDate;
    private Long providerId;
    private String roomNumber;
}
