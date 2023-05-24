package com.healthcare.appointment.repositories;

import com.healthcare.appointment.domains.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByDoctorId(long doctorId);

    Appointment findByAppointmentId(Long id);

    default Appointment update(long id, Appointment appointment) {
        Optional<Appointment> optionalAppointment = findById(id);
        if (optionalAppointment.isPresent()) {
            Appointment appointment1 = optionalAppointment.get();
            appointment1.setAppointmentDate(appointment.getAppointmentDate());
            appointment1.setProviderId(appointment.getProviderId());
            appointment1.setPatientId(appointment.getPatientId());
            appointment1.setRoomNumber(appointment.getRoomNumber());
            save(appointment1);
            return appointment1;
        } else {
            throw new RuntimeException("Appointment not found with ID: " + id);
        }
    }

}
