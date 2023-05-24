package com.healthcare.appointment.queryServices;

import com.healthcare.appointment.dtos.AppointmentDto;
import com.healthcare.appointment.dtos.Provider;

import java.util.List;


public interface IAppointmentQueryService {
    List<Provider> getAllDoctors();

    AppointmentDto searchAppointment(Long appointmentId);

    List<AppointmentDto> listAllAppointments();

    List<AppointmentDto> listAppointmentsPerDoctor(Long doctorId);
}
