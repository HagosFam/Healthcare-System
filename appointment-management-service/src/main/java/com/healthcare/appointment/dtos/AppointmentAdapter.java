package com.healthcare.appointment.dtos;

import com.healthcare.appointment.domains.Appointment;

import java.util.ArrayList;
import java.util.List;

public class AppointmentAdapter {
    public static AppointmentDto getAppointmentDTO(Appointment appointment) {
        AppointmentDto appointmentDto = new AppointmentDto();

        appointmentDto.setAppointmentId(appointment.getAppointmentId());
        appointmentDto.setAppointmentDate(appointment.getAppointmentDate());
        appointmentDto.setProviderId(appointment.getProviderId());
        appointmentDto.setPatientId(appointment.getPatientId());
        appointmentDto.setRoomNumber(appointment.getRoomNumber());
        return appointmentDto;
    }

    public static Appointment getAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = new Appointment();

        appointment.setAppointmentId(appointmentDto.getAppointmentId());
        appointment.setAppointmentDate(appointmentDto.getAppointmentDate());
        appointment.setProviderId(appointmentDto.getProviderId());
        appointment.setPatientId(appointmentDto.getPatientId());
        appointment.setRoomNumber(appointmentDto.getRoomNumber());
        return appointment;
    }

    public static List<AppointmentDto> getListAppointmentDTO(List<Appointment> appointmentList) {
        List<AppointmentDto> appointmentDtos = new ArrayList<>();
        for (Appointment list : appointmentList) {
            appointmentDtos.add(getAppointmentDTO(list));
        }
        return appointmentDtos;
    }


}
