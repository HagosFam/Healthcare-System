package miu.edu.sa.queryServices;

import miu.edu.sa.domains.Appointment;
import miu.edu.sa.domains.Doctor;

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
