package com.healthcare.appointment.commandServices;
import com.healthcare.appointment.domains.Appointment;
import com.healthcare.appointment.dtos.AppointmentAdapter;
import com.healthcare.appointment.dtos.AppointmentDto;
import com.healthcare.appointment.repositories.IAppointmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AppointmentCommandService implements IAppointmentCommandService {
    @Autowired
    IAppointmentRepository repository;

    @Override
    public AppointmentDto saveAppointment(AppointmentDto appointmentDto) {

        log.info("Appointment save: {}", appointmentDto);

        Appointment appointment = AppointmentAdapter.getAppointment(appointmentDto);
        repository.save(appointment);
        return AppointmentAdapter.getAppointmentDTO(appointment);
    }

    @Override
    public AppointmentDto changeAppointment(Long id, AppointmentDto appointmentDto) {

        log.info("Appointment change: {}/{}", id, appointmentDto);

        var appointment = repository.update(id, AppointmentAdapter.getAppointment(appointmentDto));
        return AppointmentAdapter.getAppointmentDTO(appointment);
    }

    @Override
    public void cancelAppointment(Long id) {

        log.info("Appointment cancel: {}", id);

        repository.deleteById(id);
    }
}
