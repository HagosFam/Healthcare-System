package com.healthcare.appointment.integrations.feign;

import com.healthcare.appointment.dtos.Role;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "identity-management-service")
public interface FeignIdentityManagementService {
    @GetMapping("/api/v1/identity/users/{id}")
    ResponseEntity<?> findById(@PathVariable("id") Long id);

    @GetMapping("/api/v1/identity/users/filter")
    public ResponseEntity<?> findByRole(@RequestParam("role") Role role);
}
