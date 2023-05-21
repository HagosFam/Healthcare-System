package com.healthcare.controller;

import com.healthcare.service.IBillService;
import com.healthcare.service.dto.BillDto;
import com.healthcare.service.dto.PaymentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bill")
@CrossOrigin("*")
public class BillController {

    @Autowired
    private IBillService billService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        BillDto billDto = billService.findById(id);
        if (billDto != null)
            return new ResponseEntity<>(billDto, HttpStatus.OK);
        return new ResponseEntity<>(new CustomErrorMessage("Unable to find bill."), HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(value = "patientId", required = false) Long patientId) {
        if (patientId == null)
            return new ResponseEntity<>(billService.findAll(), HttpStatus.OK);
        return new ResponseEntity<>(billService.findByPatientId(patientId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody BillDto billDto) {
        return new ResponseEntity<>(billService.save(billDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        BillDto billDto = billService.findById(id);
        if (billDto == null)
            return new ResponseEntity<>(new CustomErrorMessage("Unable to find bill."), HttpStatus.NOT_FOUND);

        billService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll() {
        billService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<?> update(Long id, @RequestBody BillDto billDto) {
        return new ResponseEntity<>(billService.update(id, billDto), HttpStatus.OK);
    }

    @PutMapping("/{id}/payment")
    public ResponseEntity<?> updatePayment(@PathVariable Long id, @RequestBody PaymentDto paymentDto) {
        BillDto billDto = billService.findById(id);
        if (billDto == null)
            return new ResponseEntity<>(new CustomErrorMessage("Unable to find bill."), HttpStatus.NOT_FOUND);

        PaymentDto _paymentDto = billDto.getPayment();
        _paymentDto.setAmount(paymentDto.getAmount());
        _paymentDto.setPaymentDate(paymentDto.getPaymentDate());

        billDto.setPayment(_paymentDto);
        return new ResponseEntity<>(billService.update(id, billDto), HttpStatus.OK);
    }
}
