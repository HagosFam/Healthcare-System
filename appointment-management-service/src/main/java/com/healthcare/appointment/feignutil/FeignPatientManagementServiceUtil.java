package com.healthcare.appointment.feignutil;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "patient-management-service")
public interface FeignPatientManagementServiceUtil {
    @GetMapping("/api/v1/patients/{id}")
    ResponseEntity<?> getById(@PathVariable("id") Long id);
}
