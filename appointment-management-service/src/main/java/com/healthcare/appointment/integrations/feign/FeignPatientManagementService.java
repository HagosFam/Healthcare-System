package com.healthcare.appointment.integrations.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "patient-management-service")
public interface FeignPatientManagementService {
    @GetMapping("/api/v1/patients/{id}")
    ResponseEntity<?> findById(@PathVariable("id") Long id);
}
