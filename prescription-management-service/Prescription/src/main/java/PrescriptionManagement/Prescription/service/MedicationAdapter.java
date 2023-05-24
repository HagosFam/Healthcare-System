package PrescriptionManagement.Prescription.service;

import PrescriptionManagement.Prescription.domain.Dosage;
import PrescriptionManagement.Prescription.domain.Medication;

import java.util.ArrayList;
import java.util.List;

public class MedicationAdapter {

    public static Medication getMedicationFromMedicationDTO(MedicationDTO medicationDTO){
        Medication medication=new Medication();
        medication.setDescription(medicationDTO.getDescription());
        medication.setManufacturer(medicationDTO.getMedicationName());
        medication.setMedicationName(medicationDTO.getMedicationName());

        for (DosageDTO dosageDTO : medicationDTO.getDosageDTOList()){
            medication.getDosageList().add(DosageAdapter.getDosageFromDosageDTO(dosageDTO));

        }
        return medication;
    }
    public static MedicationDTO getMedicationDTOFromMedication(Medication medication){
        MedicationDTO medicationDTO=new MedicationDTO();
        medicationDTO.setDescription(medication.getDescription());
        medicationDTO.setManufacturer(medication.getMedicationName());
        medicationDTO.setMedicationName(medication.getMedicationName());

        for (Dosage dosage : medication.getDosageList()){
            medicationDTO.getDosageDTOList().add(DosageAdapter.getDosageDTOFromDosage(dosage));


        }
        return medicationDTO;
    }



    public static List<MedicationDTO> getMedicationDTOListFromMedicationList(List<Medication> medicationList){
        List<MedicationDTO> medicationDTOList = new ArrayList<MedicationDTO>();
        for (Medication medication : medicationList){
            medicationDTOList.add(getMedicationDTOFromMedication(medication));
        }
        return medicationDTOList;
    }
}
