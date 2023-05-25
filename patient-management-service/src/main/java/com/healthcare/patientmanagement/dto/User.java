package com.healthcare.patientmanagement.dto;

public record User(Long id, String email,String firstName,String lastName,String password,Role role){}
