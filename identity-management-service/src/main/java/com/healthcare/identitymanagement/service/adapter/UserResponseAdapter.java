package com.healthcare.identitymanagement.service.adapter;

import com.healthcare.identitymanagement.domain.User;
import com.healthcare.identitymanagement.service.dto.UserResponseDto;
import com.healthcare.identitymanagement.service.dto.UsersDto;

import java.util.ArrayList;
import java.util.List;

public class UserResponseAdapter {
    public static UserResponseDto getUserDtoFromUser(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .role(user.getRole())
                .build();
    }

    public static User getUserFromDto(UserResponseDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .email(userDto.getEmail())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .role(userDto.getRole())
                .build();
    }

    public static UsersDto getUserResponseDtosFromUsers(List<User> users) {
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        for (User user : users)
            userResponseDtos.add(getUserDtoFromUser(user));
        return new UsersDto(userResponseDtos);
    }
}
