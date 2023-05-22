package edu.miu.ElectronicHealthRecord;

import edu.miu.ElectronicHealthRecord.model.DiagnosisReport;
import edu.miu.ElectronicHealthRecord.model.LaboratoryReport;
import edu.miu.ElectronicHealthRecord.model.MedicalRecord;
import edu.miu.ElectronicHealthRecord.service.DiagnosisReportService;
import edu.miu.ElectronicHealthRecord.service.LaboratoryReportService;
import edu.miu.ElectronicHealthRecord.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
@SpringBootApplication
public class ElectronicHealthRecordApplication implements CommandLineRunner{
	DiagnosisReportService diagnosisReportService;
	LaboratoryReportService laboratoryReportService;
	MedicalRecordService medicalRecordService;

	@Autowired
	public ElectronicHealthRecordApplication(DiagnosisReportService diagnosisReportService, LaboratoryReportService laboratoryReportService, MedicalRecordService medicalRecordService) {
		this.diagnosisReportService = diagnosisReportService;
		this.laboratoryReportService = laboratoryReportService;
		this.medicalRecordService = medicalRecordService;
	}

	public static void main(String[] args) {
		SpringApplication.run(ElectronicHealthRecordApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {;

		MedicalRecord medicalRecord1 = medicalRecordService.createMedicalRecordByPatientId(1L);
		MedicalRecord medicalRecord2 = medicalRecordService.createMedicalRecordByPatientId(2L);
		MedicalRecord medicalRecord3 = medicalRecordService.createMedicalRecordByPatientId(3L);

		DiagnosisReport diagnosisReport1 = new DiagnosisReport(null,1L,111L,
				"DIAGNOSIS CODE, THE PATIENT IS DIAGNOSIS WITH PHENOMENA, HE WAS HURT BADLY",
				"PATIENT SHOULD KEEP HIS BODY WARM TILL HE RECOVERS, HE SHOULD NOT CONSUME COLD DRINK",
				1L,null);

		diagnosisReportService.createDiagnosisReport(diagnosisReport1);

		LaboratoryReport laboratoryReport1 = new LaboratoryReport(null,1L,"urine examination","sugar in the urine 0.14mg/cc",medicalRecord1);
		laboratoryReportService.createLaboratoryReport(laboratoryReport1);

		DiagnosisReport diagnosisReport2 = new DiagnosisReport(null,2L,112L,
				"DIAGNOSIS CODE, THE PATIENT IS DIAGNOSIS WITH STOMACH PAIN.",
				"PATIENT SHOULD DRINK A LOT OF FLUID, DO NOT EAT FAT AND MEAT, TILL THE PAIN GO AWAY",
				2L,null);

		diagnosisReportService.createDiagnosisReport(diagnosisReport2);

		LaboratoryReport laboratoryReport2 = new LaboratoryReport(null,2L,"STOLE examination","bacteria in the stole was observed, E_coli infestation",medicalRecord2);
		laboratoryReportService.createLaboratoryReport(laboratoryReport2);

		DiagnosisReport diagnosisReport3 = new DiagnosisReport(null,3L,113L,
				"DIAGNOSIS CODE, THE PATIENT IS DIAGNOSIS a broken rib, caused by a collision with heavy object.",
				"PATIENT SHOULD refrain from lifting any object, exercise and sudden activities.",
				3L,medicalRecord3);

		diagnosisReportService.createDiagnosisReport(diagnosisReport3);

		LaboratoryReport laboratoryReport3 = new LaboratoryReport(null,3L,"x-ray examination","broken lower rib, a fractured bone have been found",medicalRecord3);
		laboratoryReportService.createLaboratoryReport(laboratoryReport3);

	}
}
