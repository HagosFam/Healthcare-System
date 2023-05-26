package com.healthcare.appointment.util;

import com.healthcare.appointment.dtos.Patient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class PatientMapper {
    public static Patient getPatient(ResponseEntity<?> response) {
        if (response.getStatusCode() == HttpStatus.OK) {
            Map<String, String> patientMap = (Map<String, String>) response.getBody();
            if (patientMap != null) {
                Patient patient = new Patient();
                //provider.setId(providerMap.get("id").long);
                patient.setFirstName(patientMap.get("firstName"));
                patient.setLastName(patientMap.get("lastName"));
                patient.setEmail(patientMap.get("email"));
                patient.setInsuranceId(patientMap.get("insuranceId"));
                patient.setPhoneNumber(patientMap.get("phoneNumber"));
                return patient;
            }
        }
        return null;
    }
}
