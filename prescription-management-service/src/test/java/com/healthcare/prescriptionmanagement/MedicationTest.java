package PrescriptionManagement.Prescription;

import PrescriptionManagement.Prescription.domain.Dosage;
import PrescriptionManagement.Prescription.domain.Medication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MedicationTest {

    @Test
    public void testGettersAndSetters() {
        // Create a sample medication
        Medication medication = new Medication("Medicine A", "Description A", "Manufacturer A");

        // Create a sample dosage
        Dosage dosage = new Dosage("Morning", 1, "Once daily");

        // Test getters and setters
        Assertions.assertEquals("Medicine A", medication.getMedicationName());
        Assertions.assertEquals("Description A", medication.getDescription());
        Assertions.assertEquals("Manufacturer A", medication.getManufacturer());
        Assertions.assertTrue(medication.getDosageList().isEmpty());

        medication.setMedicationName("Medicine B");
        Assertions.assertEquals("Medicine B", medication.getMedicationName());

        medication.setDescription("Description B");
        Assertions.assertEquals("Description B", medication.getDescription());

        medication.setManufacturer("Manufacturer B");
        Assertions.assertEquals("Manufacturer B", medication.getManufacturer());

        List<Dosage> dosageList = new ArrayList<>();
        dosageList.add(dosage);
        medication.setDosageList(dosageList);
        Assertions.assertEquals(dosageList, medication.getDosageList());

        medication.addDosage(new Dosage("Evening", 2, "Twice daily"));
        Assertions.assertEquals(2, medication.getDosageList().size());
    }

    @Test
    public void testToString() {
        // Create a sample medication
        Medication medication = new Medication("Medicine A", "Description A", "Manufacturer A");

        // Create a sample dosage
        Dosage dosage = new Dosage("Morning", 1, "Once daily");

        // Add dosage to medication
        medication.addDosage(dosage);

        // Test toString() method
        String expectedString = "Medication{medicationId=0, medicationName='Medicine A', description='Description A', manufacturer='Manufacturer A', dosageList=[" + dosage.toString() + "]}";
        Assertions.assertEquals(expectedString, medication.toString());
    }
}
