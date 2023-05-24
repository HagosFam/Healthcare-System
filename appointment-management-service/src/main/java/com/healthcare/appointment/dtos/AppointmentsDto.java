package com.healthcare.appointment.dtos;

import java.util.ArrayList;
import java.util.List;

public class AppointmentsDto {
    private List<AppointmentDto> appointments = new ArrayList<>();

    public AppointmentsDto(List<AppointmentDto> appointments) {
        this.appointments = appointments;
    }

    public List<AppointmentDto> getAppointments() {
        return appointments;
    }
}
