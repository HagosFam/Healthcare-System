package com.healthcare.appointment.dtos.response;
import com.healthcare.appointment.dtos.Patient;
import com.healthcare.appointment.dtos.Provider;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentResponseDto {
    private Long id;
    private Patient patient;
    private String date;
    private Provider provider;
    private String roomNumber;
}
