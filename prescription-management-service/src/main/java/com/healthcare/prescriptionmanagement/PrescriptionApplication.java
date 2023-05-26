package com.healthcare.prescriptionmanagement;

import com.healthcare.prescriptionmanagement.domain.PrescriptionStatus;
import com.healthcare.prescriptionmanagement.service.DosageDTO;
import com.healthcare.prescriptionmanagement.service.MedicationDTO;
import com.healthcare.prescriptionmanagement.service.PrescriptionDTO;
import com.healthcare.prescriptionmanagement.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PrescriptionApplication implements CommandLineRunner {
    @Autowired
    private PrescriptionService prescriptionService;
    public static void main(String[] args) {
        SpringApplication.run(PrescriptionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {



    }
}
