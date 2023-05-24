package com.healthcare.appointment.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "identity-management-service")
public interface FeignIdentityManagementServiceUtil {
    @GetMapping("/api/v1/identity/users/{id}")
    ResponseEntity<?> findById(@PathVariable("id") Long id);
}
