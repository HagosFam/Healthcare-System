package com.healthcare.appointment.commandServices;

import com.healthcare.appointment.dtos.request.AppointmentRequestDto;
import com.healthcare.appointment.dtos.response.AppointmentResponseDto;


public interface IAppointmentCommandService {
     AppointmentResponseDto saveAppointment(AppointmentRequestDto appointmentDto);

     AppointmentResponseDto changeAppointment(Long id, AppointmentRequestDto appointmentDto);

     void cancelAppointment(Long appointmentId);

}
