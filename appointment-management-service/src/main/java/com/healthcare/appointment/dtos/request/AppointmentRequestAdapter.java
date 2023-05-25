package com.healthcare.appointment.dtos.request;

import com.healthcare.appointment.domains.Appointment;

import java.util.ArrayList;
import java.util.List;

public class AppointmentRequestAdapter {
    public static AppointmentRequestDto getAppointmentDTO(Appointment appointment) {
        AppointmentRequestDto appointmentDto = AppointmentRequestDto.builder()
                .id(appointment.getId())
                .patientId(appointment.getPatientId())
                .date(appointment.getDate())
                .providerId(appointment.getProviderId())
                .roomNumber(appointment.getRoomNumber())
                .build();

        return appointmentDto;
    }

    public static Appointment getAppointment(AppointmentRequestDto appointmentDto) {
        Appointment appointment = Appointment.builder()
                .id(appointmentDto.getId())
                .patientId(appointmentDto.getPatientId())
                .date(appointmentDto.getDate())
                .providerId(appointmentDto.getProviderId())
                .roomNumber(appointmentDto.getRoomNumber())
                .build();

        return appointment;
    }

    public static AppointmentsRequestDto getListAppointmentDTO(List<Appointment> appointmentList) {
        List<AppointmentRequestDto> appointmentDtos = new ArrayList<>();
        for (Appointment list : appointmentList) {
            appointmentDtos.add(getAppointmentDTO(list));
        }
        return new AppointmentsRequestDto(appointmentDtos);
    }
}
