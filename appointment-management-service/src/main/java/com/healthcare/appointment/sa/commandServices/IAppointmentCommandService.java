package com.healthcare.appointment.sa.commandServices;

import com.healthcare.appointment.sa.domains.AppointmentDto;


public interface IAppointmentCommandService {
    public AppointmentDto saveAppointment(AppointmentDto appointmentDto);

    public AppointmentDto changeAppointment(Long id, AppointmentDto appointmentDto);

    public void cancelAppointment(Long appointmentId);

}
