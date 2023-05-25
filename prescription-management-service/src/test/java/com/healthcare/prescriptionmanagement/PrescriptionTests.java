package PrescriptionManagement.Prescription;

import PrescriptionManagement.Prescription.domain.Medication;
import PrescriptionManagement.Prescription.domain.Prescription;
import PrescriptionManagement.Prescription.domain.PrescriptionStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PrescriptionTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testGettersAndSetters() {
		// Create a sample medication
		Medication medication = new Medication();
		//medication.setName("Sample Medication");
		medication.setMedicationName("sample medication");
		// Create a sample prescription
		Prescription prescription = new Prescription(1234, medication, PrescriptionStatus.PENDING);

		// Test getters and setters
		Assertions.assertEquals(1234, prescription.getPatientId());
		Assertions.assertEquals(medication, prescription.getMedication());
		Assertions.assertEquals(PrescriptionStatus.PENDING, prescription.getStatus());

		prescription.setPatientId(5678);
		Assertions.assertEquals(5678, prescription.getPatientId());

		Medication newMedication = new Medication();
		//newMedication.setName("New Medication");
		newMedication.setMedicationName("New Medicatin");
		prescription.setMedication(newMedication);
		Assertions.assertEquals(newMedication, prescription.getMedication());

		prescription.setStatus(PrescriptionStatus.FILLED);
		Assertions.assertEquals(PrescriptionStatus.FILLED, prescription.getStatus());
	}

	@Test
	public void testToString() {
		// Create a sample medication
		Medication medication = new Medication();
		//medication//.setName("Sample Medication");
		medication.setMedicationName("Sample Medication");

		// Create a sample prescription
		Prescription prescription = new Prescription(1234, medication, PrescriptionStatus.PENDING);

		// Test toString() method
		String expectedString = "Prescription{prescriptionId=0, medication=" + medication + ", patientId=1234, status=PENDING}";
		Assertions.assertEquals(expectedString, prescription.toString());
	}
}




