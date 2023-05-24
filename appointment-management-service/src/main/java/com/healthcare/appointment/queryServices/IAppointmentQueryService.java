package com.healthcare.appointment.queryServices;

import com.healthcare.appointment.dtos.AppointmentDto;
import com.healthcare.appointment.dtos.AppointmentsDto;
import com.healthcare.appointment.dtos.Provider;

import java.util.List;


public interface IAppointmentQueryService {
    List<Provider> getAllDoctors();

    AppointmentDto searchAppointment(Long appointmentId);

    AppointmentsDto listAllAppointments();

    AppointmentsDto listAppointmentsPerDoctor(Long doctorId);
}
