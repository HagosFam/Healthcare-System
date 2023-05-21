package com.healthcare.appointment.sa.domains;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {
    private Long appointmentId;
    private Long patientId;
    private String appointmentDate;
    private Long doctorId;
    private String roomNumber;
}
