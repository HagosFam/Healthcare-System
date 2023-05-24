package com.healthcare.prescriptionmanagement.domain;

import java.util.ArrayList;
import java.util.List;

public class Prescriptions {
    private List<Prescription> prescriptions= new ArrayList<Prescription>();

    public Prescriptions() {
    }

    public Prescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }
}
