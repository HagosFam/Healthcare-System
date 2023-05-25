package com.healthcare.appointment.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Provider{
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private Role role;
}
