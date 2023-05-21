package com.healthcare.appointment.sa.queryServices;

import com.healthcare.appointment.sa.domains.AppointmentDto;
import com.healthcare.appointment.sa.domains.Doctor;

import java.util.List;


public interface IAppointmentQueryService {
    List<Doctor> getAllDoctors();

    AppointmentDto searchAppointment(Long appointmentId);

    List<AppointmentDto> listAllAppointments();

    List<AppointmentDto> listAppointmentsPerDoctor(Long doctorId);
}
