package com.healthcare.appointment.sa.controllers;

import com.healthcare.appointment.sa.commandServices.IAppointmentCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/appointment")
@CrossOrigin("*")
public class AppointmentCommandController {
    @Autowired
    IAppointmentCommandService appointmentCommandService;




}
