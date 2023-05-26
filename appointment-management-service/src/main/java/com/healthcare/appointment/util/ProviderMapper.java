package com.healthcare.appointment.util;

import com.healthcare.appointment.dtos.Provider;
import com.healthcare.appointment.dtos.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class ProviderMapper {

    public static Provider getProvider(ResponseEntity<?> response) {
        if (response.getStatusCode() == HttpStatus.OK) {
            Map<String, String> providerMap = (Map<String, String>) response.getBody();
            if (providerMap != null) {
                Provider provider = new Provider();
                //provider.setId(providerMap.get("id").long);
                provider.setEmail(providerMap.get("email"));
                provider.setFirstName(providerMap.get("firstName"));
                provider.setLastName(providerMap.get("lastName"));

                // Assuming 'role' is an enum, you may need to adjust the conversion accordingly
                provider.setRole(Role.valueOf(providerMap.get("role")));
                return provider;
            }
        }
        return null;
    }
}
