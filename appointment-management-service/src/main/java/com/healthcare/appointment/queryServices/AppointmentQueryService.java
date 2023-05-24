package com.healthcare.appointment.queryServices;

import com.healthcare.appointment.dtos.*;
import com.healthcare.appointment.feignutil.FeignIdentityManagementServiceUtil;
import com.healthcare.appointment.feignutil.FeignPatientManagementServiceUtil;
import com.healthcare.appointment.repositories.IAppointmentRepository;
import com.healthcare.appointment.domains.Appointment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AppointmentQueryService implements IAppointmentQueryService {
    @Autowired
    IAppointmentRepository repository;

    private FeignIdentityManagementServiceUtil identityManagementServiceUtil;
    private FeignPatientManagementServiceUtil patientManagementServiceUtil;

    @Override
    public List<Provider> getAllDoctors() {
        log.info("Appointment getAllDoctors");

        //TODO get all providers
        var providers = identityManagementServiceUtil.findByRole(Role.PROVIDER).getBody();
        System.out.println(providers);

        return null;
    }

    @Override
    public AppointmentDto searchAppointment(Long id) {
        log.info("Appointment get: {}", id);

        Optional<Appointment> appointmentOptional = repository.findById(id);

        if (appointmentOptional.isPresent()) {
            Appointment appointment = appointmentOptional.get();

            AppointmentDto appointmentDto = AppointmentAdapter.getAppointmentDTO(appointment);

            //TODO get provider, patient
            var provider = identityManagementServiceUtil.findById(appointment.getProviderId()).getBody();
            System.out.println(provider);

            var patient = patientManagementServiceUtil.getById(appointment.getPatientId()).getBody();
            System.out.println(patient);

            //TODO add provider and patient to appointmentDto
            //appointmentDto.setPatient();
            //appointmentDto.setProvider();

            return appointmentDto;
        }
        log.error("Unable to find appointment: {}", id);
        return null;
    }

    @Override
    public AppointmentsDto listAllAppointments() {
        log.info("Appointment listAll");

        List<Appointment> appointments = repository.findAll();

        for (Appointment appointment : appointments) {
            //TODO get provider, patient
        }

        return AppointmentAdapter.getListAppointmentDTO(appointments);
    }

    @Override
    public AppointmentsDto listAppointmentsPerDoctor(Long doctorId) {

        log.info("Appointment getAppointmentsPerProvider: provider-di={}", doctorId);

        List<Appointment> appointments = repository.findByDoctorId(doctorId);

        for (Appointment appointment : appointments) {
            //TODO get patient
        }

        return AppointmentAdapter.getListAppointmentDTO(appointments);
    }
}
