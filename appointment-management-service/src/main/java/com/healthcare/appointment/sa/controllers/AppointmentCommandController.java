package com.healthcare.appointment.sa.controllers;

import com.healthcare.appointment.sa.commandServices.IAppointmentCommandService;
import com.healthcare.appointment.sa.domains.AppointmentDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appointment")
@CrossOrigin("*")
public class AppointmentCommandController {
    @Autowired
    IAppointmentCommandService appointmentCommandService;

    @PostMapping
    @ApiOperation("Create Appointment")
    public ResponseEntity<?> saveAppointment(@RequestBody AppointmentDto appointmentDto) {
        return new ResponseEntity<>(appointmentCommandService.saveAppointment(appointmentDto), HttpStatus.OK);
    }

    @PutMapping("/{appointmentId}")
    @ApiOperation("Change Appointment")
    public ResponseEntity<?> changeAppointment(@PathVariable("appointmentId") Long appointmentId, @RequestBody AppointmentDto appointmentDto) {
        return new ResponseEntity<>(appointmentCommandService.changeAppointment(appointmentId, appointmentDto), HttpStatus.OK);
    }

    @DeleteMapping("/{appointmentId}")
    @ApiOperation("Cancel Appointment")
    public ResponseEntity<?> cancelAppointment(@PathVariable("appointmentId") Long appointmentId) {
        appointmentCommandService.cancelAppointment(appointmentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
