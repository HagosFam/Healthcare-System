package com.healthcare.electronichealthrecord;

import com.healthcare.electronichealthrecord.service.DiagnosisReportService;
import com.healthcare.electronichealthrecord.service.LaboratoryReportService;
import com.healthcare.electronichealthrecord.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ElectronicHealthRecordApplication implements CommandLineRunner{

	@Autowired
	public ElectronicHealthRecordApplication(DiagnosisReportService diagnosisReportService, LaboratoryReportService laboratoryReportService, MedicalRecordService medicalRecordService) {
	}

	public static void main(String[] args) {
		SpringApplication.run(ElectronicHealthRecordApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {;
	}
}
