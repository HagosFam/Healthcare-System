package com.healthcare.appointment.queryServices;

import com.healthcare.appointment.repositories.IAppointmentRepository;
import com.healthcare.appointment.domains.Appointment;
import com.healthcare.appointment.domains.AppointmentAdapter;
import com.healthcare.appointment.domains.AppointmentDto;
import com.healthcare.appointment.domains.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
