package com.healthcare.appointment.dtos.response;

import com.healthcare.appointment.domains.Appointment;

import java.util.ArrayList;
import java.util.List;

public class AppointmentResponseAdapter {
    public static AppointmentResponseDto getAppointmentDTO(Appointment appointment) {
        AppointmentResponseDto appointmentDto = AppointmentResponseDto.builder()
                .id(appointment.getId())
                .date(appointment.getDate())
                .roomNumber(appointment.getRoomNumber())
                .build();

        return appointmentDto;
    }

    public static Appointment getAppointment(AppointmentResponseDto appointmentDto) {
        Appointment appointment = Appointment.builder()
                .id(appointmentDto.getId())
                .date(appointmentDto.getDate())
                .roomNumber(appointmentDto.getRoomNumber())
                .build();

        if(appointmentDto.getPatient() != null)
            appointment.setPatientId(appointmentDto.getPatient().getId());
        if(appointmentDto.getProvider() != null)
            appointment.setProviderId(appointmentDto.getProvider().getId());

        return appointment;
    }

    public static AppointmentsResponseDto getListAppointmentDTO(List<Appointment> appointmentList) {
        List<AppointmentResponseDto> appointmentDtos = new ArrayList<>();
        for (Appointment list : appointmentList) {
            appointmentDtos.add(getAppointmentDTO(list));
        }
        return new AppointmentsResponseDto(appointmentDtos);
    }
}
