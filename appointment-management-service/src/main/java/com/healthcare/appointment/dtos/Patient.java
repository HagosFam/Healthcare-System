package com.healthcare.appointment.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Patient{
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String insuranceId;
    private String email;
    private Address address;
}
