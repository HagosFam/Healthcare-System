package com.healthcare.appointment.sa.queryServices;

import com.healthcare.appointment.sa.domains.Appointment;
import com.healthcare.appointment.sa.domains.AppointmentAdapter;
import com.healthcare.appointment.sa.domains.AppointmentDto;
import com.healthcare.appointment.sa.domains.Doctor;
import com.healthcare.appointment.sa.repositories.IAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentQueryService implements IAppointmentQueryService {
    @Autowired
    IAppointmentRepository repository;

    @Override
    public List<Doctor> getAllDoctors() {
        return null;
    }

    @Override
    public AppointmentDto searchAppointment(Long appointmentId) {
        return repository.findById(appointmentId).map(AppointmentAdapter::getAppointmentDTO).orElse(null);
    }

    @Override
    public List<AppointmentDto> listAllAppointments() {
        List<Appointment> appointmentList = repository.findAll();
        return AppointmentAdapter.getListAppointmentDTO(appointmentList);
    }

    @Override
    public List<AppointmentDto> listAppointmentsPerDoctor(Long doctorId) {
        List<Appointment> list = repository.findByDoctorId(doctorId);
        return AppointmentAdapter.getListAppointmentDTO(list);
    }
}
