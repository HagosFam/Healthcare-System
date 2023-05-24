package com.healthcare.appointment.dtos;

import lombok.Data;
import lombok.Getter;

@Data
public class Patient{
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String insuranceId;
    private String email;
    private Address address;
}
