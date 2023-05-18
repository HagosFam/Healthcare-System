package miu.edu.sa.commandServices;

import miu.edu.sa.domains.Appointment;
import org.springframework.stereotype.Service;

@Service
public interface IAppointmentCommandService {
    public Appointment createAppointment(Appointment appointment);
    public Appointment changeAppointment(Appointment appointment);
    public void cancelAppointment(String appointmentId);

}
