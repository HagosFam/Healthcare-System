package edu.miu.ElectronicHealthRecord.service;

import edu.miu.ElectronicHealthRecord.model.DiagnosisReport;
import edu.miu.ElectronicHealthRecord.model.LaboratoryReport;
import edu.miu.ElectronicHealthRecord.model.MedicalRecord;
import edu.miu.ElectronicHealthRecord.model.Patient;
import edu.miu.ElectronicHealthRecord.repository.MedicalRecordRepository;
import edu.miu.ElectronicHealthRecord.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
   public class MedicalRecordService {
    private final PatientRepository patientRepository;
   private final MedicalRecordRepository medicalRecordRepository;
    RestTemplate restTemplate = new RestTemplate();

    /** for local network simulation purpose only. **/
   final String url = "http://localhost:8088/patient/";
   @Autowired
   public MedicalRecordService(PatientRepository patientRepository,MedicalRecordRepository medicalRecordRepository){
       this.patientRepository = patientRepository;
       this.medicalRecordRepository = medicalRecordRepository;
   }
    //post
    public MedicalRecord createMedicalRecord(Long patientId){

                        Patient patient = restTemplate.getForObject(url + patientId, Patient.class);

                        if (patient != null && patientRepository.findByPatientId(patientId).orElse(null) == null) {
                            patientRepository.save(patient);

                            List<DiagnosisReport> diagnosisList = new ArrayList<>();
                            List<LaboratoryReport> laborastoryList = new ArrayList<>();
                            Set<String> allergies = new HashSet<>();
                            MedicalRecord medicalRecord = new MedicalRecord();

                            medicalRecord.setPatientId(patientId);
                            medicalRecord.setAllergy(allergies);
                            medicalRecord.setLaboratoryReports(laborastoryList);
                            medicalRecord.setDiagnosisReports(diagnosisList);
                            return medicalRecordRepository.save(medicalRecord);
                        }
                        if(patient != null){
                        System.out.println("The patient has been register in the  system. Medical record is already available");
                        return null;
                        }
                    return null;
    }
   public MedicalRecord findMedicalRecordById(Long medicalRecordId){
       MedicalRecord medicalRecord = medicalRecordRepository.findById(medicalRecordId).orElse(null);
       return medicalRecord;
   }

   public List<MedicalRecord> findAllMedicalRecords(){
       List<MedicalRecord> medicalRecordList = medicalRecordRepository.findAll();
       return medicalRecordList;
   }

    public void deleteMedicalRecordById(Long medicalRecordId){
        medicalRecordRepository.deleteById(medicalRecordId);
    }


    public MedicalRecord updateMedicalRecord(Long id, MedicalRecord medicalRecord){

        MedicalRecord editMedicalRecord = medicalRecordRepository.findById(id).orElse(null);
        editMedicalRecord.setDiagnosisReports(medicalRecord.getDiagnosisReports());
        editMedicalRecord.setLaboratoryReports(medicalRecord.getLaboratoryReports());
        editMedicalRecord.setAllergy(medicalRecord.getAllergy());
        MedicalRecord updatedResult = medicalRecordRepository.save(editMedicalRecord);
        return updatedResult;
    }

    public Set<String> addAllergy(Long medicalRecordId, List<String> allergy){
        MedicalRecord editMedicalRecord = medicalRecordRepository.findById(medicalRecordId).orElse(null);
       if(editMedicalRecord != null) {
           Set<String> allergies = editMedicalRecord.getAllergy();
           allergy.forEach(element -> allergies.add(element));
           editMedicalRecord.setAllergy(allergies);
           MedicalRecord medicalRecord = medicalRecordRepository.save(editMedicalRecord);
           return medicalRecord.getAllergy();
       }
       return null;
    }
    public void deleteAllergy(Long medicalRecordId){
        MedicalRecord medicalRecord= medicalRecordRepository.findById(medicalRecordId).orElse(null);
        Set<String> newset = new HashSet<>();
        medicalRecord.setAllergy(newset);
        medicalRecordRepository.save(medicalRecord);
    }
    public Set<String> getAllergyList(Long medicalRecordId){
        MedicalRecord medicalRecord = medicalRecordRepository.findById(medicalRecordId).orElse(null);
        Set<String> allergies = medicalRecord.getAllergy();
        return allergies;
    }
    }


