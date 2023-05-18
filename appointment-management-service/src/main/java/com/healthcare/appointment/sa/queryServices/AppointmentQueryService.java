package com.healthcare.appointment.sa.queryServices;

import com.healthcare.appointment.sa.domains.Appointment;
import com.healthcare.appointment.sa.domains.Doctor;

import java.util.List;

public class AppointmentQueryService implements IAppointmentQueryService {
    @Override
    public List<Doctor> getAllDoctors() {
        return null;
    }

    @Override
    public Appointment searchAppointment(String appointmentId) {
        return null;
    }

    @Override
    public List<Appointment> listAllAppointments() {
        return null;
    }

    @Override
    public List<Appointment> listAppointmentPerDoctor(String doctorId) {
        return null;
    }
}
