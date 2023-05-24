package com.healthcare.appointment.controllers;

import com.healthcare.appointment.commandServices.IAppointmentCommandService;
import com.healthcare.appointment.dtos.AppointmentDto;
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
public class AppointmentCommandController {
    @Autowired
    IAppointmentCommandService appointmentCommandService;

    @PostMapping
    @ApiOperation("Create Appointment")
    public ResponseEntity<?> saveAppointment(@RequestBody AppointmentDto appointmentDto) {
        log.info("Appointment save: {}", appointmentDto);

        return new ResponseEntity<>(appointmentCommandService.saveAppointment(appointmentDto), HttpStatus.OK);
    }

    @PutMapping("/{appointmentId}")
    @ApiOperation("Change Appointment")
    public ResponseEntity<?> changeAppointment(@PathVariable("appointmentId") Long id, @RequestBody AppointmentDto appointmentDto) {
        log.info("Appointment change: {}/{}",id, appointmentDto);
        return new ResponseEntity<>(appointmentCommandService.changeAppointment(id, appointmentDto), HttpStatus.OK);
    }

    @DeleteMapping("/{appointmentId}")
    @ApiOperation("Cancel Appointment")
    public ResponseEntity<?> cancelAppointment(@PathVariable("appointmentId") Long id) {
        log.info("Appointment cancel: {}",id);
        appointmentCommandService.cancelAppointment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
