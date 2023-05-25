package com.healthcare.appointment.dtos.response;

import java.util.ArrayList;
import java.util.List;

public class AppointmentsResponseDto {
    private List<AppointmentResponseDto> appointments;

    public AppointmentsResponseDto(List<AppointmentResponseDto> appointments) {
        this.appointments = appointments;
    }

    public List<AppointmentResponseDto> getAppointments() {
        return appointments;
    }
}
