package com.healthcare.identitymanagement.service;

import com.healthcare.identitymanagement.domain.User;
import com.healthcare.identitymanagement.repository.UserRepository;
import com.healthcare.identitymanagement.service.adapter.UserResponseAdapter;
import com.healthcare.identitymanagement.service.dto.JwtTokenDto;
import com.healthcare.identitymanagement.service.dto.LoginRequestDto;
import com.healthcare.identitymanagement.service.dto.LoginResponseDto;
import com.healthcare.identitymanagement.service.dto.UserResponseDto;
import com.healthcare.identitymanagement.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    public LoginResponseDto login(LoginRequestDto loginRequest) {
        try {
            var result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(e.getMessage());
        }

        Optional<User> userCredentialOptional = userRepository.findByEmail(loginRequest.getEmail());

        User userCredential = null;
        if(userCredentialOptional.isPresent()) {
            userCredential = userCredentialOptional.get();

            final String accessToken = jwtUtil.generateToken(userCredential);
            final String refreshToken = jwtUtil.generateRefreshToken(loginRequest.getEmail());
            var jwtResponse = new JwtTokenDto(accessToken, refreshToken);

            return new LoginResponseDto(jwtResponse, UserResponseAdapter.getUserDtoFromUser(userCredential));
        }
        return null;
    }

    public JwtTokenDto refreshToken(JwtTokenDto refreshTokenRequest) {
        boolean isRefreshTokenValid = jwtUtil.validateToken(refreshTokenRequest.getRefreshToken());
        if (isRefreshTokenValid) {
            final String accessToken = jwtUtil.doGenerateToken(jwtUtil.getSubject(refreshTokenRequest.getRefreshToken()));
            return new JwtTokenDto(accessToken, refreshTokenRequest.getRefreshToken());
        }
        return new JwtTokenDto();
    }
}
