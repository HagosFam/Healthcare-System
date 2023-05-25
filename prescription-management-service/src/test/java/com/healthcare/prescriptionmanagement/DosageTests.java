package PrescriptionManagement.Prescription;

import PrescriptionManagement.Prescription.domain.Dosage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DosageTests {

    @Test
    public void testGettersAndSetters() {
        // Create a sample dosage
        Dosage dosage = new Dosage("Morning", 1, "Once daily");

        // Test getters and setters
        Assertions.assertEquals("Morning", dosage.getDosageNmae());
        Assertions.assertEquals(1, dosage.getQuantity());
        Assertions.assertEquals("Once daily", dosage.getFrequency());

        dosage.setDosageNmae("Afternoon");
        Assertions.assertEquals("Afternoon", dosage.getDosageNmae());

        dosage.setQuantity(2);
        Assertions.assertEquals(2, dosage.getQuantity());

        dosage.setFrequency("Twice daily");
        Assertions.assertEquals("Twice daily", dosage.getFrequency());
    }

    @Test
    public void testToString() {
        // Create a sample dosage
        Dosage dosage = new Dosage("Morning", 1, "Once daily");

        // Test toString() method
        String expectedString = "Dosage{dosageId=0, dosageNmae='Morning', quantity=1, frequency='Once daily'}";
        Assertions.assertEquals(expectedString, dosage.toString());
    }
}
