package com.healthcare.appointment.sa.queryServices;

import com.healthcare.appointment.sa.domains.Appointment;
import com.healthcare.appointment.sa.domains.Doctor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IAppointmentQueryService {
    public List<Doctor> getAllDoctors();

    public Appointment searchAppointment(String appointmentId);

    public List<Appointment> listAllAppointments();

    public List<Appointment> listAppointmentPerDoctor(String doctorId);
}
