package com.healthcare.appointment.queryServices;

import com.healthcare.appointment.domains.AppointmentDto;
import com.healthcare.appointment.domains.Doctor;

import java.util.List;


public interface IAppointmentQueryService {
    List<Doctor> getAllDoctors();

    AppointmentDto searchAppointment(Long appointmentId);

    List<AppointmentDto> listAllAppointments();

    List<AppointmentDto> listAppointmentsPerDoctor(Long doctorId);
}
