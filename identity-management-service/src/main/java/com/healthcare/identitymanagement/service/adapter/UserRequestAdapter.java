package com.healthcare.identitymanagement.service.adapter;

import com.healthcare.identitymanagement.domain.User;
import com.healthcare.identitymanagement.service.dto.UserRequestDto;

public class UserRequestAdapter {
    public static UserRequestDto getUserDtoFromUser(User user) {
        return UserRequestDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .role(user.getRole())
                .build();
    }

    public static User getUserFromDto(UserRequestDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .email(userDto.getEmail())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .role(userDto.getRole())
                .build();
    }
}
