package com.healthcare.appointment.sa.commandServices;

import com.healthcare.appointment.sa.domains.Appointment;
import com.healthcare.appointment.sa.domains.AppointmentAdapter;
import com.healthcare.appointment.sa.domains.AppointmentDto;
import com.healthcare.appointment.sa.repositories.IAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentCommandService implements IAppointmentCommandService {
    @Autowired
    IAppointmentRepository appointmentRepository;

    @Override
    public AppointmentDto saveAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = AppointmentAdapter.getAppointment(appointmentDto);
        appointmentRepository.save(appointment);
        return AppointmentAdapter.getAppointmentDTO(appointment);
    }

    @Override
    public AppointmentDto changeAppointment(Long id, AppointmentDto appointmentDto) {
        var appointment = appointmentRepository.update(id, AppointmentAdapter.getAppointment(appointmentDto));
        return AppointmentAdapter.getAppointmentDTO(appointment);
    }

    @Override
    public void cancelAppointment(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }
}
