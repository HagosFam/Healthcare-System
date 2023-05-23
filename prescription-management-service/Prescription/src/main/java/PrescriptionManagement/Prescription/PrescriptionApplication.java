package PrescriptionManagement.Prescription;

import PrescriptionManagement.Prescription.domain.Dosage;
import PrescriptionManagement.Prescription.domain.Medication;
import PrescriptionManagement.Prescription.domain.Prescription;
import PrescriptionManagement.Prescription.domain.PrescriptionStatus;
import PrescriptionManagement.Prescription.proxy.Patient;

import PrescriptionManagement.Prescription.repository.MedicationRepository;
import PrescriptionManagement.Prescription.service.DosageService;
import PrescriptionManagement.Prescription.service.PrescriptionService;
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


Medication md= new Medication("one","two","three");

		long giveMeMedicationID=prescriptionService.WriteMedication( "Azthmatic","pills for two month","cleveland hospital");


		Dosage ds11= new Dosage("Keclomethasone",3, "daily");
//dosageService.creatDosage(ds11);

//System.out.println(dosageService.getDosage(1));
		Dosage ds22=	 new Dosage("Zometasone",1,"weekly");


	    long id2=	prescriptionService.addDoseForMedication(giveMeMedicationID,ds11);
	            prescriptionService.addDoseForMedication(giveMeMedicationID,ds22);
Prescription k=			prescriptionService.createPrescription(12,id2,PrescriptionStatus.FILLED);
Prescription prescription=prescriptionService.ViewPrescription(1);
		System.out.println(prescription);

		Prescription pk= prescriptionService.ViewPrescrptionForPatient(12);
		System.out.println("For patient that is created: "+pk);
		Medication md2= new Medication("four","five","six");
	//	long f= prescriptionService.WriteMedication(md2);
//		Medication x=prescriptionService.getmed(f);
//		System.out.println(x);

		List<Medication> medicationList=medicationRepository.findAll();
		for(Medication m:medicationList){
			System.out.println(m);
		}
	}
}
