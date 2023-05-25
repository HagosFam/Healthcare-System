package com.healthcare.appointment.queryServices;

import com.healthcare.appointment.dtos.response.AppointmentResponseDto;
import com.healthcare.appointment.dtos.response.AppointmentsResponseDto;
import com.healthcare.appointment.dtos.Provider;

import java.util.List;


public interface IAppointmentQueryService {
    List<Provider> getAllDoctors();

    AppointmentResponseDto searchAppointment(Long appointmentId);

    AppointmentsResponseDto listAllAppointments();

    AppointmentsResponseDto listAppointmentsPerDoctor(Long doctorId);
}
