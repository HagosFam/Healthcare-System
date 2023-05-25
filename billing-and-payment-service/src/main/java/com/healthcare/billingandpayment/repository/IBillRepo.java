package com.healthcare.billingandpayment.repository;

import com.healthcare.billingandpayment.domain.Bill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
