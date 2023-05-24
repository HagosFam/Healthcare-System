package PrescriptionManagement.Prescription.service;

import PrescriptionManagement.Prescription.domain.Dosage;

public class DosageAdapter {

    public static Dosage getDosageFromDosageDTO(DosageDTO dosageDTO){

        Dosage dosage=new Dosage();
        dosage.setDosageId(dosage.getDosageId());
        dosage.setDosageNmae(dosageDTO.getDosageNmae());
        dosage.setFrequency(dosageDTO.getFrequency());
        dosage.setQuantity(dosageDTO.getQuantity());

        return dosage;
    }
    public static DosageDTO getDosageDTOFromDosage(Dosage dosage){

        DosageDTO dosageDTO=new DosageDTO();
        dosageDTO.setDosageNmae(dosage.getDosageNmae());
        dosageDTO.setQuantity(dosage.getQuantity());
        dosageDTO.setFrequency(dosage.getFrequency());
       dosageDTO.setDosageId(dosage.getDosageId());
        return dosageDTO;
    }
}
