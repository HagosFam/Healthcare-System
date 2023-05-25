package com.healthcare.prescriptionmanagement.service;

import com.healthcare.prescriptionmanagement.domain.Dosage;
import com.healthcare.prescriptionmanagement.domain.Medication;
import com.healthcare.prescriptionmanagement.domain.Prescription;
import com.healthcare.prescriptionmanagement.domain.PrescriptionStatus;
import com.healthcare.prescriptionmanagement.repository.DosageRepository;
import com.healthcare.prescriptionmanagement.repository.MedicationRepository;
import com.healthcare.prescriptionmanagement.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService {
    @Autowired
    private MedicationRepository medicationRepository;
    @Autowired
    private DosageRepository dosageRepository;
    @Autowired
    private PrescriptionRepository prescriptionRepository;


public Medication getmed(long medicationId){
     return medicationRepository.findById(medicationId).get();
}
//    public long WriteMedication(String medicationName, String description, String manufacture) {
//        Medication md = new Medication(medicationName, description, manufacture);
//        medicationRepository.save(md);
//        return md.getMedicationId();
//    }
public long WriteMedication(Medication md) {
  //  Medication md1 = MedicationAdapter.getMedicationFromMedicationDTO(md);
    medicationRepository.save(md);
    return md.getMedicationId();
}

    public long addDoseForMedication(long medicationId, Dosage dosage) {
        Medication m = medicationRepository.findById(medicationId).get();
        dosageRepository.save(dosage);
        Dosage dosage1 = dosageRepository.findById(dosage.getDosageId()).get();
        m.addDosage(dosage1);
        medicationRepository.save(m);
        return m.getMedicationId();
    }

    public Prescription createPrescription(long patientId, long medicatonId, PrescriptionStatus status) {
      //  Patient patient = restTemplate.getForObject(serverUrl + "/{patientId}", Patient.class, patientId);
        Medication m = medicationRepository.findById(medicatonId).get();
        Prescription pr = new Prescription(patientId, m, status);
        prescriptionRepository.save(pr);
        return prescriptionRepository.findById(pr.getPrescriptionId()).get();
      //  System.out.println("Presecription Created for: " + patient);

    }
    public  void UpdatePrescription(long patientId, long prescriptionId, PrescriptionStatus status,String medicationName, String description, String manufacture, Dosage dosage) {
       // Patient patient = restTemplate.getForObject(serverUrl + "/{patientId}", Patient.class, patientId);
        Prescription ps= prescriptionRepository.findById(prescriptionId).get();
        Medication m = new Medication(medicationName,description,manufacture);
        ps.setMedication(m);
        ps.setPatientId(patientId);
        ps.setStatus(status);
        PrescriptionService lj= new PrescriptionService();
        long k= m.getMedicationId();
        long h= lj.addDoseForMedication(k,dosage);
        prescriptionRepository.save(ps);
       //System.out.println("Presecription update for: " + patient);

    }

    public Prescription ViewPrescription(long prescriptionId){
         return prescriptionRepository.findById(prescriptionId).get();
    }

    public void DeletePrescription(long prescriptionId){
       Prescription ps= prescriptionRepository.findById(prescriptionId).get();
       prescriptionRepository.delete(ps);
       System.out.println("Prescription: "+ps+" deleted");
    }

    public Prescription ViewPrescrptionForPatient(long patientId){
       // Patient patient = restTemplate.getForObject(serverUrl + "/{patientId}", Patient.class, patientId);
        return prescriptionRepository.findByPatientId(patientId);
    }

   public List<Prescription>getAllPrescriptions(){
        return prescriptionRepository.findAll();
   }








































    //    RestTemplate restTemplate = new RestTemplate();
//    private String serverUrl = "http://localhost:8090/patients";

//    public Patient getPatiet(long patientId) {
//        Patient patient = restTemplate.getForObject(serverUrl + "/{patientId}", Patient.class, patientId);
//        return patient;
//    }

    // @RequestParam(value= "patientId") long patientId,
    // @RequestParam(value= "medicationId") long medicationId,
    //  @RequestParam(value="dosage") Dosage dosage,
    // @RequestParam(value= "status")PrescriptionStatus status
}
