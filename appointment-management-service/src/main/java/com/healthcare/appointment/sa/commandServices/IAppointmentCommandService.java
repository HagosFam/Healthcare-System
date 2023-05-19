package com.healthcare.appointment.sa.commandServices;

import com.healthcare.appointment.sa.domains.AppointmentDto;


public interface IAppointmentCommandService {
     AppointmentDto saveAppointment(AppointmentDto appointmentDto);

     AppointmentDto changeAppointment(Long id, AppointmentDto appointmentDto);

     void cancelAppointment(Long appointmentId);

}
