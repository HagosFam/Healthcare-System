package com.healthcare.appointment.controllers;

import com.healthcare.appointment.queryServices.IAppointmentQueryService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appointments")
@CrossOrigin("*")
@Slf4j
public class AppointmentQueryController {
    @Autowired
    IAppointmentQueryService queryService;

    @GetMapping("/doctors")
    @ApiOperation("Get all doctors")
    public ResponseEntity<?> getAllDoctors() {
        log.info("Appointment getAll");

        return new ResponseEntity<>(queryService.getAllDoctors(), HttpStatus.OK);
    }

    @GetMapping("/{appointmentId}")
    @ApiOperation("Search appointments")
    public ResponseEntity<?> searchAppointment(@PathVariable("appointmentId") Long id) {
        log.info("Appointment search: {}", id);

        return new ResponseEntity<>(queryService.searchAppointment(id), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation("Get all appointments")
    public ResponseEntity<?> listAllAppointments() {
        log.info("Appointment listAll");

        return new ResponseEntity<>(queryService.listAllAppointments(), HttpStatus.OK);
    }

    @GetMapping("doctors/{doctorId}")
    @ApiOperation("Get appointment per doctor")
    public ResponseEntity<?> getAppointmentPerDoctor(@PathVariable Long doctorId) {
        log.info("Appointment getAppointment: {}", doctorId);

        return new ResponseEntity<>(queryService.listAppointmentsPerDoctor(doctorId), HttpStatus.OK);
    }
}