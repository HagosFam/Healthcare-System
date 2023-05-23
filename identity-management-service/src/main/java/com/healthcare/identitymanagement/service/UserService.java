package com.healthcare.identitymanagement.service;

import com.healthcare.identitymanagement.config.CustomUserDetails;
import com.healthcare.identitymanagement.domain.User;
import com.healthcare.identitymanagement.repository.UserRepository;
import com.healthcare.identitymanagement.service.adapter.UserRequestAdapter;
import com.healthcare.identitymanagement.service.adapter.UserResponseAdapter;
import com.healthcare.identitymanagement.service.dto.UserRequestDto;
import com.healthcare.identitymanagement.service.dto.UserResponseDto;
import com.healthcare.identitymanagement.service.dto.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserResponseDto findById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.map(UserResponseAdapter::getUserDtoFromUser).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> credential = userRepository.findByEmail(email);
        return credential.map(CustomUserDetails::new).orElse(null);
    }

    public UserResponseDto save(UserRequestDto userRequestDto) {
        User user = UserRequestAdapter.getUserFromDto(userRequestDto);
        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        return UserResponseAdapter.getUserDtoFromUser(userRepository.save(user));
    }

    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    public UsersDto findAll() {
        return UserResponseAdapter.getUserResponseDtosFromUsers(userRepository.findAll());
    }
}
