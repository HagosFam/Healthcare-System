package PrescriptionManagement.Prescription.domain;

import jakarta.persistence.*;

@Entity
public class Dosage {
    @Id
    @GeneratedValue
    private long dosageId;
    private String dosageNmae;
    private int quantity;
    private String frequency;

    public Dosage() {
    }

    public Dosage(String dosageNmae, int quantity, String frequency) {
        this.dosageNmae = dosageNmae;
        this.quantity = quantity;
        this.frequency = frequency;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }

    public long getDosageId() {
        return dosageId;
    }

    public void setDosageId(long dosageId) {
        this.dosageId = dosageId;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getDosageNmae() {
        return dosageNmae;
    }

    public void setDosageNmae(String dosageNmae) {
        this.dosageNmae = dosageNmae;
    }

    @Override
    public String toString() {
        return "Dosage{" +
                "dosageId=" + dosageId +
                ", dosageNmae='" + dosageNmae + '\'' +
                ", quantity=" + quantity +
                ", frequency='" + frequency + '\'' +
                '}';
    }
}
