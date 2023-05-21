package com.healthcare.repository;

import com.healthcare.domain.Bill;
import com.healthcare.service.dto.BillDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IBillRepo extends JpaRepository<Bill, Long> {
    List<Bill> findByPatientId(long patientId);
    default Bill update(long id, Bill updatedBill) {
        Optional<Bill> optionalBill = findById(id);
        if (optionalBill.isPresent()) {
            Bill bill = optionalBill.get();
            bill.setPatientId(updatedBill.getPatientId());
            bill.setServicesRendered(updatedBill.getServicesRendered());
            bill.setPayment(updatedBill.getPayment());
            save(bill);
            return bill;
        } else {
            throw new RuntimeException("Bill not found with ID: " + id);
        }
    }
}
