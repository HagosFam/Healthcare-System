package com.healthcare.billingandpayment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BillingAndPaymentServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BillingAndPaymentServiceApplication.class, args);
	}

	@Override
	public void run(String[] args) {
	}

}
