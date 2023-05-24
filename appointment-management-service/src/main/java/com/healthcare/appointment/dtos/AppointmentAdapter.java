package com.healthcare.appointment.dtos;

import com.healthcare.appointment.domains.Appointment;

import java.util.ArrayList;
import java.util.List;

public class AppointmentAdapter {
    public static AppointmentDto getAppointmentDTO(Appointment appointment) {
        AppointmentDto appointmentDto = AppointmentDto.builder()
                .id(appointment.getId())
                .date(appointment.getDate())
                .roomNumber(appointment.getRoomNumber())
                .build();

        return appointmentDto;
    }

    public static Appointment getAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = Appointment.builder()
                .id(appointmentDto.getId())
                .patientId(appointmentDto.getPatient().getId())
                .date(appointmentDto.getDate())
                .providerId(appointmentDto.getProvider().getId())
                .roomNumber(appointmentDto.getRoomNumber())
                .build();

        return appointment;
    }

    public static AppointmentsDto getListAppointmentDTO(List<Appointment> appointmentList) {
        List<AppointmentDto> appointmentDtos = new ArrayList<>();
        for (Appointment list : appointmentList) {
            appointmentDtos.add(getAppointmentDTO(list));
        }
        return new AppointmentsDto(appointmentDtos);
    }
}
