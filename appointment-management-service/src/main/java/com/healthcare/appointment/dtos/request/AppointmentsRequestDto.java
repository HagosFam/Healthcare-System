package com.healthcare.appointment.dtos.request;

import java.util.ArrayList;
import java.util.List;

public class AppointmentsRequestDto {
    private List<AppointmentRequestDto> appointments;

    public AppointmentsRequestDto(List<AppointmentRequestDto> appointments) {
        this.appointments = appointments;
    }

    public List<AppointmentRequestDto> getAppointments() {
        return appointments;
    }
}
