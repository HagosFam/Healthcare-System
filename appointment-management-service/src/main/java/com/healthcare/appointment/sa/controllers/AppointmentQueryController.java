package com.healthcare.appointment.sa.controllers;

import com.healthcare.appointment.sa.queryServices.IAppointmentQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/appointment")
@CrossOrigin("*")
public class AppointmentQueryController {
    @Autowired
    IAppointmentQueryService service;
}
