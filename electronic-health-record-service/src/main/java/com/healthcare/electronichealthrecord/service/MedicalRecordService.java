package com.healthcare.electronichealthrecord.service;

import com.healthcare.electronichealthrecord.repository.PatientRepository;
import com.healthcare.electronichealthrecord.model.MedicalRecord;
import com.healthcare.electronichealthrecord.model.Patient;
import com.healthcare.electronichealthrecord.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;


@Service
   public class MedicalRecordService {
    private final PatientRepository patientRepository;
   private final MedicalRecordRepository medicalRecordRepository;
    RestTemplate restTemplate = new RestTemplate();
   final String url = "http://localhost:8088/patient/";
   @Autowired
   public MedicalRecordService(PatientRepository patientRepository,MedicalRecordRepository medicalRecordRepository){
       this.patientRepository = patientRepository;
       this.medicalRecordRepository = medicalRecordRepository;
   }
    //post
    public MedicalRecord createMedicalRecordByPatientId(Long patientId){
        Patient patient = restTemplate.getForObject(url + patientId ,Patient.class);

                    if(medicalRecordRepository.findByPatientId(patientId).isEmpty() && patient !=null){
                        patientRepository.save(patient);
                        MedicalRecord medicalRecord = new MedicalRecord(null,patientId,null,null,null);
                     MedicalRecord createdMedicalRecord =    medicalRecordRepository.save(medicalRecord);
                        return createdMedicalRecord;
                    }
                    MedicalRecord medicalRecord = medicalRecordRepository.getReferenceById(patientId);
                    System.out.print("medical record already exist");
                    return medicalRecord;
    }
   public MedicalRecord findMedicalRecordById(Long medicalRecordId){
       MedicalRecord medicalRecord = medicalRecordRepository.findById(medicalRecordId).orElse(null);
       return medicalRecord;
   }

   public List<MedicalRecord> findAllMedicalRecords(){
       List<MedicalRecord> medicalRecordList = medicalRecordRepository.findAll();
       return medicalRecordList;
   }
//delete
    public void deleteMedicalRecordById(Long medicalRecordId){
        medicalRecordRepository.deleteById(medicalRecordId);
    }

    //update
    public MedicalRecord editMedicalRecordPatientId(Long medicalRecordId, Long patientId){
        MedicalRecord editMedicalRecord = medicalRecordRepository.getReferenceById(medicalRecordId);
        editMedicalRecord.setPatientId(patientId);
        MedicalRecord medicalRecord = medicalRecordRepository.save(editMedicalRecord);
        return medicalRecord;
    }

    public Set<String> addAllergy(Long medicalRecordId, String allergy){
        MedicalRecord editMedicalRecord = medicalRecordRepository.getReferenceById(medicalRecordId);
        Set<String> allergies = editMedicalRecord.getAllergy();
        allergies.add(allergy);
        editMedicalRecord.setAllergy(allergies);
        MedicalRecord medicalRecord = medicalRecordRepository.save(editMedicalRecord);
        return  medicalRecord.getAllergy();
    }
    public void deleteSpecificAllergy(Long medicalRecordId, String allergy){
        MedicalRecord editMedicalRecord = medicalRecordRepository.getReferenceById(medicalRecordId);
        Set<String> allergies = editMedicalRecord.getAllergy();
        allergies.remove(allergy);
        editMedicalRecord.setAllergy(allergies);
        medicalRecordRepository.save(editMedicalRecord);
    }
    public Set<String> getAllergyList(Long medicalRecordId){
        MedicalRecord medicalRecord = medicalRecordRepository.getReferenceById(medicalRecordId);
        return medicalRecord.getAllergy();
    }
    }


