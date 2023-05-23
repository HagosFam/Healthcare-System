package com.healthcare.appointment.commandServices;

import com.healthcare.appointment.domains.AppointmentDto;


public interface IAppointmentCommandService {
     AppointmentDto saveAppointment(AppointmentDto appointmentDto);

     AppointmentDto changeAppointment(Long id, AppointmentDto appointmentDto);

     void cancelAppointment(Long appointmentId);

}
