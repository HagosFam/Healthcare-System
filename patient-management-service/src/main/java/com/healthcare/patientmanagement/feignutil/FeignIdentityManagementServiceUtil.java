package com.healthcare.patientmanagement.feignutil;

import com.healthcare.patientmanagement.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "identity-management-service")
public interface FeignIdentityManagementServiceUtil {
    @PostMapping("/api/v1/identity/users")
    ResponseEntity<?> save(@RequestBody User user);
}
