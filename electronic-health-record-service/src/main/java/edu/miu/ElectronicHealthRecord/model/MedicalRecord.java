package edu.miu.ElectronicHealthRecord.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long patientId;
    @OneToMany(mappedBy = "medicalRecord",fetch = FetchType.EAGER)
    private List<DiagnosisReport> diagnosisReports = new ArrayList<>();
    @OneToMany(mappedBy = "medicalRecord",fetch = FetchType.EAGER)
    private List<LaboratoryReport> laboratoryReports = new ArrayList<>();
    @ElementCollection()
    @JoinTable(name = "Patient_Allergies")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<String> allergy;
}
