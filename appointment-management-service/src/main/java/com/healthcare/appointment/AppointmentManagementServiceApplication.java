package com.healthcare.appointment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AppointmentManagementServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AppointmentManagementServiceApplication.class, args);
    }

    @Override
    public void run(String[] args) throws Exception {
        System.out.println("Appointment service running");

    }
}
