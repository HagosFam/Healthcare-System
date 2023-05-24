package com.healthcare.patientmanagement.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "identity-management-service")
public interface FeignIdentityManagementServiceUtil {
    @PostMapping("/api/v1/identity/users")
    ResponseEntity<?> save(@RequestBody User user);
}
