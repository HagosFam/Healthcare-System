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

    //DTO done
    public MedicationDTO getmed(long medicationId){

        Medication medication= medicationRepository.findById(medicationId).get();
        return MedicationAdapter.getMedicationDTOFromMedication(medication);
    }
    //dto done
    public long WriteMedication(MedicationDTO md) {
        Medication md1 = MedicationAdapter.getMedicationFromMedicationDTO(md);
        medicationRepository.save(md1);
        return md1.getMedicationId();
    }

    //DTO  done
    public long addDoseForMedication(long medicationId, DosageDTO dosageDTO) {
        Medication m = medicationRepository.findById(medicationId).get();
        Dosage dosage=DosageAdapter.getDosageFromDosageDTO(dosageDTO);
        dosageRepository.save(dosage);
        Dosage dosage1 = dosageRepository.findById(dosage.getDosageId()).get();
        m.addDosage(dosage1);
        medicationRepository.save(m);
        return m.getMedicationId();
    }
    //dto done
    public  PrescriptionDTO createPrescription(long patientId, long medicatonId, PrescriptionStatus status) {
        //  Patient patient = restTemplate.getForObject(serverUrl + "/{patientId}", Patient.class, patientId);
        Medication m = medicationRepository.findById(medicatonId).get();
        Prescription pr = new Prescription(patientId, m, status);
        prescriptionRepository.save(pr);
        Prescription prescription= prescriptionRepository.findById(pr.getPrescriptionId()).get();
        return PrescriptionAdapter.getPrescriptionDTOFromPrescription(prescription);


    }
    //dto done
    public  void UpdatePrescription(long patientId, long prescriptionId, PrescriptionStatus status,String medicationName, String description, String manufacture, DosageDTO dosageDTO) {
        // Patient patient = restTemplate.getForObject(serverUrl + "/{patientId}", Patient.class, patientId);
        Prescription ps= prescriptionRepository.findById(prescriptionId).get();
        Medication m = new Medication(medicationName,description,manufacture);
        ps.setMedication(m);
        ps.setPatientId(patientId);
        ps.setStatus(status);
        PrescriptionService lj= new PrescriptionService();
        long k= m.getMedicationId();
        long h= lj.addDoseForMedication(k,dosageDTO);
        prescriptionRepository.save(ps);


    }
    //DTO DONE
    public PrescriptionDTO ViewPrescription(long prescriptionId){
        Prescription prescription= prescriptionRepository.findById(prescriptionId).get();
        return PrescriptionAdapter.getPrescriptionDTOFromPrescription(prescription);
    }
    //done dto
    public PrescriptionDTO ViewPrescrptionForPatient(long patientId){
        // Patient patient = restTemplate.getForObject(serverUrl + "/{patientId}", Patient.class, patientId);
        Prescription prescription= prescriptionRepository.findByPatientId(patientId);
        return PrescriptionAdapter.getPrescriptionDTOFromPrescription(prescription);

    }
    //DONE DTO
    public void DeletePrescription(long prescriptionId){
        Prescription ps= prescriptionRepository.findById(prescriptionId).get();
        prescriptionRepository.delete(ps);

    }

    //done dto
    public List<PrescriptionDTO>getAllPrescriptions(){
        List<Prescription> prescriptionList= prescriptionRepository.findAll();
        return PrescriptionAdapter.getPrescriptionDTOListFromPrescriptionList(prescriptionList);
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
