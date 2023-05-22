package com.healthcare.appointment.commandServices;
import com.healthcare.appointment.domains.Appointment;
import com.healthcare.appointment.domains.AppointmentAdapter;
import com.healthcare.appointment.domains.AppointmentDto;
import com.healthcare.appointment.repositories.IAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentCommandService implements IAppointmentCommandService {
    @Autowired
    IAppointmentRepository repository;

    @Override
    public AppointmentDto saveAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = AppointmentAdapter.getAppointment(appointmentDto);
        repository.save(appointment);
        return AppointmentAdapter.getAppointmentDTO(appointment);
    }

    @Override
    public AppointmentDto changeAppointment(Long id, AppointmentDto appointmentDto) {
        var appointment = repository.update(id, AppointmentAdapter.getAppointment(appointmentDto));
        return AppointmentAdapter.getAppointmentDTO(appointment);
    }

    @Override
    public void cancelAppointment(Long appointmentId) {
        repository.deleteById(appointmentId);
    }
}
