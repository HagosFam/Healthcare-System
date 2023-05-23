package com.healthcare.identitymanagement.service.dto;

import java.util.List;

public class UsersDto {
    public List<UserResponseDto> users;

    public UsersDto(List<UserResponseDto> users){
        this.users = users;
    }

    public List<UserResponseDto> getUsers(){
        return users;
    }
}
