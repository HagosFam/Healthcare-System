package PrescriptionManagement.Prescription.service;

import PrescriptionManagement.Prescription.domain.Dosage;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

public class MedicationDTO {

    private long medicationId;
    private String medicationName;
    private String description;
    private String manufacturer;

    private List<DosageDTO> dosageDTOList= new ArrayList<>();

    public MedicationDTO() {
    }

    public MedicationDTO(String medicationName, String description, String manufacturer) {
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

    public List<DosageDTO> getDosageDTOList() {
        return dosageDTOList;
    }

//    public DosageDTO getDosageDTO(){
//        dosageDTOList.
//    }

    public void setDosageDTOList(DosageDTO dosageDTO) {
        this.dosageDTOList.add(dosageDTO);
    }

    @Override
    public String toString() {
        return "MedicationDTO{" +
                "medicationId=" + medicationId +
                ", medicationName='" + medicationName + '\'' +
                ", description='" + description + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", dosageDTOList=" + dosageDTOList +
                '}';
    }
}
