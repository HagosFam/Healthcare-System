package com.healthcare.appointment.dtos.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentRequestDto {
    private Long id;
    private Long patientId;
    private String date;
    private Long providerId;
    private String roomNumber;
}
