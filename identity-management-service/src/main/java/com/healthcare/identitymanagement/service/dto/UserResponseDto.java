package com.healthcare.identitymanagement.service.dto;


import com.healthcare.identitymanagement.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private long id;
    private String email;
    private String firstName;
    private String lastName;
    private Role role;
}
