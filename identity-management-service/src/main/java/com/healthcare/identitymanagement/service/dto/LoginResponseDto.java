package com.healthcare.identitymanagement.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto {
    private JwtTokenDto jwtResponse;
    private UserResponseDto userResponse;
}
