package com.healthcare.patientmanagement.mapper;

import com.healthcare.patientmanagement.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.healthcare.patientmanagement.dto.PatientDto;

@Mapper
public interface AutoPatientMapper {

//    provide mapper implementation of interface at compilation
    AutoPatientMapper MAPPER = Mappers.getMapper(AutoPatientMapper.class);

    Patient mapToPatient(PatientDto patientDto);

    PatientDto mapToPatientDto(Patient patient);

}
