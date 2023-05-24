package com.healthcare.appointment.queryServices;

import com.healthcare.appointment.repositories.IAppointmentRepository;
import com.healthcare.appointment.domains.Appointment;
import com.healthcare.appointment.domains.AppointmentAdapter;
import com.healthcare.appointment.domains.AppointmentDto;
import com.healthcare.appointment.domains.Doctor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AppointmentQueryService implements IAppointmentQueryService {
    @Autowired
    IAppointmentRepository repository;

    @Override
    public List<Doctor> getAllDoctors() {
        log.info("Appointment getAllDoctors");

        return null;
    }

    @Override
    public AppointmentDto searchAppointment(Long id) {
        log.info("Appointment get: {}", id);

        return repository.findById(id).map(AppointmentAdapter::getAppointmentDTO).orElse(null);
    }

    @Override
    public List<AppointmentDto> listAllAppointments() {
        log.info("Appointment listAll");

        List<Appointment> appointmentList = repository.findAll();
        return AppointmentAdapter.getListAppointmentDTO(appointmentList);
    }

    @Override
    public List<AppointmentDto> listAppointmentsPerDoctor(Long doctorId) {

        log.info("Appointment getAppointmentsPerProvider: provider-di={}", doctorId);

        List<Appointment> list = repository.findByDoctorId(doctorId);
        return AppointmentAdapter.getListAppointmentDTO(list);
    }
}
