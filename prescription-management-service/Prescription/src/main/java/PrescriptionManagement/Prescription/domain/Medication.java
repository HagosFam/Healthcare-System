package PrescriptionManagement.Prescription.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Medication {
    @Id
    @GeneratedValue
    private long medicationId;
    private String medicationName;
    private String description;
    private String manufacturer;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Dosage> dosageList= new ArrayList<>();

    public Medication() {
    }

    public Medication(String medicationName, String description, String manufacturer) {
        this.medicationName = medicationName;
        this.description = description;
        this.manufacturer = manufacturer;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public List<Dosage> getDosageList() {
        return dosageList;
    }

    public long getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(long medicationId) {
        this.medicationId = medicationId;
    }

    public void addDosage(Dosage dosage) {
        this.dosageList.add(dosage);
    }

    public void setDosageList(List<Dosage> dosageList) {
        this.dosageList = dosageList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "medicationId=" + medicationId +
                ", medicationName='" + medicationName + '\'' +
                ", description='" + description + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", dosageList=" + dosageList +
                '}';
    }
}
