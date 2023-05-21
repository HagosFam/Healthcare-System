package patientmanagementservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import patientmanagementservice.dto.PatientDto;
import patientmanagementservice.entity.Patient;

@Mapper
public interface AutoPatientMapper {

//    provide mapper implementation of interface at compilation
    AutoPatientMapper MAPPER = Mappers.getMapper(AutoPatientMapper.class);

    Patient mapToPatient(PatientDto patientDto);

    PatientDto mapToPatientDto(Patient patient);

}
