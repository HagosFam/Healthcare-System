package com.healthcare.prescriptionmanagement.service;



import com.healthcare.prescriptionmanagement.domain.Prescription;

import java.util.ArrayList;
import java.util.List;

public class PrescriptionAdapter {



    public static Prescription getPrescriptionFromPrescriptionDTO(PrescriptionDTO prescriptionDTO){
        Prescription prescription= new Prescription();
        prescription.setPatientId(prescriptionDTO.getPatientId());
        prescription.setPrescriptionId(prescription.getPrescriptionId());
        prescription.setStatus(prescriptionDTO.getStatus());
        prescription.setMedication(MedicationAdapter.getMedicationFromMedicationDTO(prescriptionDTO.getMedicationDTO()));
    return prescription;
    }



    public static PrescriptionDTO getPrescriptionDTOFromPrescription(Prescription prescription){
        PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
        prescriptionDTO.setPrescriptionId(prescription.getPrescriptionId());
        prescriptionDTO.setStatus(prescription.getStatus());
        prescriptionDTO.setPatientId(prescription.getPatientId());
        prescriptionDTO.setMedicationDTO(MedicationAdapter.getMedicationDTOFromMedication(prescription.getMedication()));

      return prescriptionDTO;


    }

    public static List<PrescriptionDTO> getPrescriptionDTOListFromPrescriptionList(List<Prescription> prescriptionList){

        List<PrescriptionDTO>prescriptionDTOList=new ArrayList<>();
        for (Prescription prescription : prescriptionList){

            prescriptionDTOList.add(getPrescriptionDTOFromPrescription(prescription));
        }
        return prescriptionDTOList;
    }


}
