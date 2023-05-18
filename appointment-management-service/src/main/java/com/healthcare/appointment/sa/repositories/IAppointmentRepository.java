package com.healthcare.appointment.sa.repositories;

import com.healthcare.appointment.sa.domains.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByAppointmentId(long appointmentId);
    default Appointment update(long id, Appointment appointment) {
        Optional<Appointment> optionalAppointment = findById(id);
        if (optionalAppointment.isPresent()) {
            Appointment appointment1 = optionalAppointment.get();
            appointment1.setAppointmentDate(appointment.getAppointmentDate());
            appointment1.setDoctorId(appointment.getDoctorId());
            appointment1.setPatientId(appointment.getPatientId());
            appointment1.setRoomNumber(appointment.getRoomNumber());
            save(appointment1);
            return appointment1;
        } else {
            throw new RuntimeException("Appointment not found with ID: " + id);
        }
    }

}
