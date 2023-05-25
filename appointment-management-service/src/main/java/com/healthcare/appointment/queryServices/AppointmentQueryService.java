package com.healthcare.appointment.queryServices;

import com.healthcare.appointment.dtos.*;
import com.healthcare.appointment.dtos.response.AppointmentResponseAdapter;
import com.healthcare.appointment.dtos.response.AppointmentResponseDto;
import com.healthcare.appointment.dtos.response.AppointmentsResponseDto;
import com.healthcare.appointment.integrations.feign.FeignIdentityManagementService;
import com.healthcare.appointment.integrations.feign.FeignPatientManagementService;
import com.healthcare.appointment.repositories.IAppointmentRepository;
import com.healthcare.appointment.domains.Appointment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
        if(providerResponse.getStatusCode() == HttpStatus.OK)
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

            //GET Provider
//            ResponseEntity<?> providerResponse = identityManagementService.findById(appointment.getProviderId());
//            if(providerResponse.getStatusCode() == HttpStatus.OK)
//            {
//                Provider provider = (Provider)providerResponse.getBody();
//                if(provider != null)
//                    appointmentDto.setProvider(provider);
//            }

            //GET patient
//            ResponseEntity<?> patientResponse = patientManagementService.findById(appointment.getPatientId());
//            if(patientResponse.getStatusCode() == HttpStatus.OK)
//            {
//                Patient patient= (Patient) patientResponse.getBody();
//                if(patient != null)
//                    appointmentDto.setPatient(patient);
//            }

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
//            ResponseEntity<?> providerResponse = identityManagementService.findById(appointment.getProviderId());
//            if(providerResponse.getStatusCode() == HttpStatus.OK)
//            {
//                Provider provider = (Provider)providerResponse.getBody();
//                if(provider != null)
//                    appointmentResponseDto.setProvider(provider);
//            }

            //GET patient
//            ResponseEntity<?> patientResponse = patientManagementService.findById(appointment.getPatientId());
//            if(patientResponse.getStatusCode() == HttpStatus.OK)
//            {
//                Patient patient= (Patient) patientResponse.getBody();
//                if(patient != null)
//                    appointmentResponseDto.setPatient(patient);
//            }
            appointmentsDto.add(appointmentResponseDto);
        }

        return AppointmentResponseAdapter.getListAppointmentDTO(appointments);
    }

    @Override
    public AppointmentsResponseDto listAppointmentsPerDoctor(Long doctorId) {

        log.info("Appointment getAppointmentsPerProvider: provider-di={}", doctorId);

        List<Appointment> appointments = repository.findByProviderId(doctorId);

        List<AppointmentResponseDto> appointmentsDto = new ArrayList<>();
        for (Appointment appointment : appointments) {
            AppointmentResponseDto appointmentResponseDto = AppointmentResponseAdapter.getAppointmentDTO(appointment);

            //GET patient
//            ResponseEntity<?> patientResponse = patientManagementService.findById(appointment.getPatientId());
//            if(patientResponse.getStatusCode() == HttpStatus.OK)
//            {
//                Patient patient= (Patient) patientResponse.getBody();
//                if(patient != null)
//                    appointmentResponseDto.setPatient(patient);
//            }
            appointmentsDto.add(appointmentResponseDto);
        }

        return AppointmentResponseAdapter.getListAppointmentDTO(appointments);
    }
}
