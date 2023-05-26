package com.healthcare.prescriptionmanagement.service;


import com.healthcare.prescriptionmanagement.domain.PrescriptionStatus;

public class PrescriptionDTO {

    private long prescriptionId;

    private MedicationDTO medicationDTO;


    private long patientId;
    private PrescriptionStatus status;

    public PrescriptionDTO() {
    }

    public PrescriptionDTO(MedicationDTO medicationDTO, long patientId, PrescriptionStatus status) {
        this.medicationDTO = medicationDTO;
        this.patientId = patientId;
        this.status = status;
    }

    public MedicationDTO getMedicationDTO() {
        return medicationDTO;
    }

    public void setMedicationDTO(MedicationDTO medicationDTO) {
        this.medicationDTO = medicationDTO;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public PrescriptionStatus getStatus() {
        return status;
    }

    public void setStatus(PrescriptionStatus status) {
        this.status = status;
    }

    public long getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    @Override
    public String toString() {
        return "PrescriptionDTO{" +
                "prescriptionId=" + prescriptionId +
                ", medicationDTO=" + medicationDTO +
                ", patientId=" + patientId +
                ", status=" + status +
                '}';
    }
}
