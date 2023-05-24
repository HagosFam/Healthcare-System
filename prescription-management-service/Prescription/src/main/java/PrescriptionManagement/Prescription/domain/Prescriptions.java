package PrescriptionManagement.Prescription.domain;

import PrescriptionManagement.Prescription.service.PrescriptionDTO;

import java.util.ArrayList;
import java.util.List;

public class Prescriptions {

    private List<PrescriptionDTO> prescriptions= new ArrayList<PrescriptionDTO>();


    public Prescriptions() {
    }

    public Prescriptions(List<PrescriptionDTO> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public List<PrescriptionDTO> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<PrescriptionDTO> prescriptions) {
        this.prescriptions = prescriptions;
    }
}
