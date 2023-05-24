package PrescriptionManagement.Prescription;

import PrescriptionManagement.Prescription.domain.Dosage;
import PrescriptionManagement.Prescription.domain.Medication;
import PrescriptionManagement.Prescription.domain.Prescription;
import PrescriptionManagement.Prescription.domain.PrescriptionStatus;
import PrescriptionManagement.Prescription.proxy.Patient;

import PrescriptionManagement.Prescription.repository.MedicationRepository;
import PrescriptionManagement.Prescription.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class PrescriptionApplication implements CommandLineRunner {


	@Autowired
	private PrescriptionService prescriptionService;
@Autowired
	private DosageService dosageService;
@Autowired
private MedicationRepository medicationRepository;

	public static void main(String[] args) {
		SpringApplication.run(PrescriptionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//
//		MedicationDTO md= new MedicationDTO("one","two","three");
//		System.out.println(md);
////
//		long giveMeMedicationID=prescriptionService.WriteMedication( md);
//////
////
//		DosageDTO ds11= new DosageDTO("Keclomethasone",3, "daily");
//////dosageService.creatDosage(ds11);
////
//////System.out.println(dosageService.getDosage(1));
////		Dosage ds22=	 new Dosage("Zometasone",1,"weekly");
////
////
//		long id2=	prescriptionService.addDoseForMedication(giveMeMedicationID,ds11);
//		//prescriptionService.addDoseForMedication(giveMeMedicationID,ds22);
//		PrescriptionDTO k=			prescriptionService.createPrescription(12,id2,PrescriptionStatus.FILLED);
//		//PrescriptionDTO prescription=prescriptionService.ViewPrescription(1);
//		//System.out.println(prescription);
////
//		PrescriptionDTO pk= prescriptionService.ViewPrescrptionForPatient(12);
//		System.out.println("For patient that is created: "+pk);
//		Medication md2= new Medication("four","five","six");
//		long f= prescriptionService.WriteMedication(md2);
//		Medication x=prescriptionService.getmed(f);
//		System.out.println(x);

//
//		List<Medication> medicationList=medicationRepository.findAll();
//		for(Medication m:medicationList){
//			System.out.println(m);




			//medicationName=hermon&description=one&manufacture=last&
	//	}
	}
}
