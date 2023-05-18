package miu.edu.sa.queryServices;

import miu.edu.sa.domains.Appointment;
import miu.edu.sa.domains.Doctor;

import java.util.List;

public interface IAppointmentQueryService {
    public List<Doctor> getAllDoctors();

    public Appointment searchAppointment(String appointmentId);

    public List<Appointment> listAllAppointments();

    public List<Appointment> listAppointmentPerDoctor(String doctorId);
}
