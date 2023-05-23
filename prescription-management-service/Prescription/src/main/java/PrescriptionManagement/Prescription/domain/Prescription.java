package PrescriptionManagement.Prescription.domain;

import jakarta.persistence.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Entity
public class Prescription {
    @Id
    @GeneratedValue
    private long prescriptionId;
    @ManyToOne(fetch = FetchType.EAGER)
    private Medication medication;


    private long patientId;
    private PrescriptionStatus status;

    public Prescription() {
    }

    public Prescription(long patientId,Medication medication ,PrescriptionStatus status) {
        this.patientId=patientId;
       this.medication=medication;
       this.status=status;

    }

    public long getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public PrescriptionStatus getStatus() {
        return status;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public void setStatus(PrescriptionStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "prescriptionId=" + prescriptionId +
                ", medication=" + medication +
                ", patientId=" + patientId +
                ", status=" + status +
                '}';
    }
}
