package com.healthcare.appointment.sa.controllers;

import com.healthcare.appointment.sa.queryServices.IAppointmentQueryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appointment")
@CrossOrigin("*")
public class AppointmentQueryController {
    @Autowired
    IAppointmentQueryService queryService;

    @GetMapping("/doctors")
    @ApiOperation("Get all doctors")
    public ResponseEntity<?> getAllDoctors() {
        return new ResponseEntity<>(queryService.getAllDoctors(), HttpStatus.OK);
    }

    @GetMapping("/{appointmentId}")
    @ApiOperation("Search appointments")
    public ResponseEntity<?> searchAppointment(@PathVariable("appointmentId") Long appointmentId) {
        return new ResponseEntity<>(queryService.searchAppointment(appointmentId), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation("Get all appointments")
    public ResponseEntity<?> listAllAppointments() {
        return new ResponseEntity<>(queryService.listAllAppointments(), HttpStatus.OK);
    }

    @GetMapping("doctors/{doctorId}")
    @ApiOperation("Get appointment per doctor")
    public ResponseEntity<?> getAppointmentPerDoctor(@PathVariable Long doctorId) {
        return new ResponseEntity<>(queryService.listAppointmentsPerDoctor(doctorId), HttpStatus.OK);
    }


}
