package com.healthcare.identitymanagement.service.dto;

import java.util.ArrayList;
import java.util.List;

public class UsersResponseDto {
    public List<UserResponseDto> users = new ArrayList<>();

    public UsersResponseDto(List<UserResponseDto> users){
        this.users = users;
    }

    public List<UserResponseDto> getUsers(){
        return users;
    }
}
