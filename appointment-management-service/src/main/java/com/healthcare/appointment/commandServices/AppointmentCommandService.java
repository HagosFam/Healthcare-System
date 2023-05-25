package com.healthcare.appointment.commandServices;
import com.healthcare.appointment.domains.Appointment;
import com.healthcare.appointment.dtos.Patient;
import com.healthcare.appointment.dtos.Provider;
import com.healthcare.appointment.dtos.request.AppointmentRequestAdapter;
import com.healthcare.appointment.dtos.request.AppointmentRequestDto;
import com.healthcare.appointment.dtos.response.AppointmentResponseAdapter;
import com.healthcare.appointment.dtos.response.AppointmentResponseDto;
import com.healthcare.appointment.integrations.feign.FeignIdentityManagementService;
import com.healthcare.appointment.integrations.feign.FeignPatientManagementService;
import com.healthcare.appointment.repositories.IAppointmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AppointmentCommandService implements IAppointmentCommandService {
    @Autowired
    IAppointmentRepository repository;

    @Autowired
    private FeignIdentityManagementService identityManagementService;

    @Autowired
    private FeignPatientManagementService patientManagementService;

    @Override
    public AppointmentResponseDto saveAppointment(AppointmentRequestDto appointmentDto) {

        log.info("Appointment save: {}", appointmentDto);

        Appointment appointment = AppointmentRequestAdapter.getAppointment(appointmentDto);
        repository.save(appointment);

        AppointmentResponseDto responseDto = AppointmentResponseAdapter.getAppointmentDTO(appointment);

        //GET provider
//        ResponseEntity<?> providerResponse = identityManagementService.findById(appointment.getProviderId());
//        if(providerResponse.getStatusCode() == HttpStatus.OK)
//        {
//            Provider provider = (Provider)providerResponse.getBody();
//            if(provider != null)
//                responseDto.setProvider(provider);
//        }
//
//        //GET Patient
//        ResponseEntity<?> patientResponse = patientManagementService.findById(appointment.getPatientId());
//        if(patientResponse.getStatusCode() == HttpStatus.OK)
//        {
//            Patient patient = (Patient)patientResponse.getBody();
//            if(patient != null)
//                responseDto.setPatient(patient);
//        }

        return responseDto;
    }

    @Override
    public AppointmentResponseDto changeAppointment(Long id, AppointmentRequestDto appointmentDto) {

        log.info("Appointment change: {}/{}", id, appointmentDto);

        var appointment = repository.update(id, AppointmentRequestAdapter.getAppointment(appointmentDto));
        return AppointmentResponseAdapter.getAppointmentDTO(appointment);
    }

    @Override
    public void cancelAppointment(Long id) {

        log.info("Appointment cancel: {}", id);

        repository.deleteById(id);
    }
}
