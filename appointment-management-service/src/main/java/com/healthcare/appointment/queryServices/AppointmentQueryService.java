package com.healthcare.appointment.queryServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.healthcare.appointment.dtos.*;
import com.healthcare.appointment.dtos.response.AppointmentResponseAdapter;
import com.healthcare.appointment.dtos.response.AppointmentResponseDto;
import com.healthcare.appointment.dtos.response.AppointmentsResponseDto;
import com.healthcare.appointment.integrations.feign.FeignIdentityManagementService;
import com.healthcare.appointment.integrations.feign.FeignPatientManagementService;
import com.healthcare.appointment.repositories.IAppointmentRepository;
import com.healthcare.appointment.domains.Appointment;
import com.healthcare.appointment.util.Mapper;
import com.healthcare.appointment.util.PatientMapper;
import com.healthcare.appointment.util.ProviderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class AppointmentQueryService implements IAppointmentQueryService {
    @Autowired
    IAppointmentRepository repository;

    @Autowired
    private FeignIdentityManagementService identityManagementService;

    @Autowired
    private FeignPatientManagementService patientManagementService;

    @Override
    public List<Provider> getAllDoctors() {
        log.info("Appointment getAllDoctors");

        List<Provider> providers = new ArrayList<>();

        //GET Provider
        ResponseEntity<?> providerResponse = identityManagementService.findByRole(Role.PROVIDER);
        if (providerResponse.getStatusCode() == HttpStatus.OK)
            providers.addAll((List<Provider>) Objects.requireNonNull(providerResponse.getBody()));

        return providers;
    }

    @Override
    public AppointmentResponseDto searchAppointment(Long id) {
        log.info("Appointment get: {}", id);

        Optional<Appointment> appointmentOptional = repository.findById(id);

        if (appointmentOptional.isPresent()) {
            Appointment appointment = appointmentOptional.get();

            AppointmentResponseDto appointmentDto = AppointmentResponseAdapter.getAppointmentDTO(appointment);

            try {
                //GET Provider
                ResponseEntity<?> providerResponse = identityManagementService.findById(appointment.getProviderId());
                Provider provider = ProviderMapper.getProvider(providerResponse);
                if(provider != null)
                    appointmentDto.setProvider(provider);

                //GET patient
                ResponseEntity<?> patientResponse = patientManagementService.findById(appointment.getPatientId());
                Patient patient = PatientMapper.getPatient(patientResponse);
                if(patient != null)
                    appointmentDto.setPatient(patient);

            } catch (Exception ex) {
                log.error("Unable to get provider/patient: {}", id);
            }

            return appointmentDto;
        }
        log.error("Unable to find appointment: {}", id);
        return null;
    }

    @Override
    public AppointmentsResponseDto listAllAppointments() {
        log.info("Appointment listAll");

        List<Appointment> appointments = repository.findAll();

        List<AppointmentResponseDto> appointmentsDto = new ArrayList<>();
        for (Appointment appointment : appointments) {
            AppointmentResponseDto appointmentResponseDto = AppointmentResponseAdapter.getAppointmentDTO(appointment);

            //GET Provider
            ResponseEntity<?> providerResponse = identityManagementService.findById(appointment.getProviderId());
            Provider provider = ProviderMapper.getProvider(providerResponse);
            if(provider != null)
                appointmentResponseDto.setProvider(provider);

            //GET patient
            ResponseEntity<?> patientResponse = patientManagementService.findById(appointment.getPatientId());
            Patient patient = PatientMapper.getPatient(patientResponse);
            if(patient != null)
                appointmentResponseDto.setPatient(patient);

            appointmentsDto.add(appointmentResponseDto);
        }
        return new AppointmentsResponseDto(appointmentsDto);
    }

    @Override
    public AppointmentsResponseDto listAppointmentsPerDoctor(Long doctorId) {

        log.info("Appointment getAppointmentsPerProvider: provider-di={}", doctorId);

        List<Appointment> appointments = repository.findByProviderId(doctorId);

        List<AppointmentResponseDto> appointmentsDto = new ArrayList<>();
        for (Appointment appointment : appointments) {
            AppointmentResponseDto appointmentResponseDto = AppointmentResponseAdapter.getAppointmentDTO(appointment);

            //GET patient
            ResponseEntity<?> patientResponse = patientManagementService.findById(appointment.getPatientId());
            Patient patient = PatientMapper.getPatient(patientResponse);
            if(patient != null)
                appointmentResponseDto.setPatient(patient);

            appointmentsDto.add(appointmentResponseDto);
        }

        return AppointmentResponseAdapter.getListAppointmentDTO(appointments);
    }
}
