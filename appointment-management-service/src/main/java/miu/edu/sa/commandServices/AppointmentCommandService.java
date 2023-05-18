package miu.edu.sa.commandServices;

import miu.edu.sa.domains.Appointment;
import miu.edu.sa.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentCommandService implements IAppointmentCommandService {
    @Autowired
    AppointmentRepository appointmentRepository;

    @Override
    public Appointment createAppointment(Appointment appointment) {
       // logic
        return appointment;
    }

    @Override
    public Appointment changeAppointment(Appointment appointment) {
        // logic

        return appointment;
    }

    @Override
    public void cancelAppointment(String appointmentId) {

    }
}
