package com.healthcare.billingandpayment.controller;

import com.healthcare.billingandpayment.service.IBillService;
import com.healthcare.billingandpayment.service.dto.BillDto;
import com.healthcare.billingandpayment.service.dto.PaymentDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bills")
@CrossOrigin("*")
public class BillController {

    private static final Logger logger = LoggerFactory.getLogger(BillController.class);

    @Autowired
    private IBillService billService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        logger.info("Bill find: {}", id);

        BillDto billDto = billService.findById(id);
        if (billDto != null)
            return new ResponseEntity<>(billDto, HttpStatus.OK);
        return new ResponseEntity<>(new CustomErrorMessage("Unable to find bill."), HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(value = "patientId", required = false) Long patientId) {
        logger.info("Bill findAll");

        if (patientId == null)
            return new ResponseEntity<>(billService.findAll(), HttpStatus.OK);
        return new ResponseEntity<>(billService.findByPatientId(patientId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody BillDto billDto) {
        logger.info("Bill save: {}", billDto);

        return new ResponseEntity<>(billService.save(billDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        logger.info("Bill delete: {}", id);

        BillDto billDto = billService.findById(id);
        if (billDto == null)
            return new ResponseEntity<>(new CustomErrorMessage("Unable to find bill."), HttpStatus.NOT_FOUND);

        billService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll() {
        logger.info("Bill deleteAll");

        billService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<?> update(Long id, @RequestBody BillDto billDto) {
        logger.info("Bill update: bill-id={}/{}", id, billDto);

        return new ResponseEntity<>(billService.update(id, billDto), HttpStatus.OK);
    }

    @PutMapping("/{id}/payment")
    public ResponseEntity<?> updatePayment(@PathVariable Long id, @RequestBody PaymentDto paymentDto) {

        logger.info("Bill updatePayment: bill-id={}/{}", id, paymentDto);

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
