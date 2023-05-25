package com.healthcare.prescriptionmanagement.service;

public class DosageDTO {

    private long dosageId;
    private String dosageNmae;
    private int quantity;
    private String frequency;

    public DosageDTO() {
    }

    public DosageDTO(String dosageNmae, int quantity, String frequency) {
        this.dosageNmae = dosageNmae;
        this.quantity = quantity;
        this.frequency = frequency;
    }

    public String getDosageNmae() {
        return dosageNmae;
    }

    public void setDosageNmae(String dosageNmae) {
        this.dosageNmae = dosageNmae;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public long getDosageId() {
        return dosageId;
    }

    public void setDosageId(long dosageId) {
        this.dosageId = dosageId;
    }

    @Override
    public String toString() {
        return "DosageDTO{" +
                "dosageId=" + dosageId +
                ", dosageNmae='" + dosageNmae + '\'' +
                ", quantity=" + quantity +
                ", frequency='" + frequency + '\'' +
                '}';
    }
}
