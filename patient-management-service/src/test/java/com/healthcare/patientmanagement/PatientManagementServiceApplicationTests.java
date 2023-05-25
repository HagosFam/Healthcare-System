package com.healthcare.patientmanagement;

import com.healthcare.patientmanagement.dto.PatientDto;
import com.healthcare.patientmanagement.entity.Patient;
import com.healthcare.patientmanagement.exception.PhoneNumberAlreadyExistsException;
import com.healthcare.patientmanagement.integration.feign.FeignIdentityManagementService;
import com.healthcare.patientmanagement.repository.PatientRepository;
import com.healthcare.patientmanagement.service.impl.PatientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class PatientManagementServiceApplicationTests {

	@Mock
	private PatientRepository patientRepository;

	@Mock
	private FeignIdentityManagementService identityManagementServiceUtil;

	@InjectMocks
	private PatientServiceImpl patientService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testGetPatient() {
		Long patientId = 1L;
		Patient patient = new Patient();
		patient.setId(patientId);
		when(patientRepository.findById(patientId)).thenReturn(Optional.of(patient));

		PatientDto result = patientService.getPatient(patientId);

		assertNotNull(result);
		assertEquals(patientId, result.getId());
	}

	@Test
	void testGetPatientByPhoneNumberOrEmail() {
		String phoneNumberOrEmail = "1234567890";
		Patient patient = new Patient();
		when(patientRepository.getPatientByPhoneNumberOrEmail(phoneNumberOrEmail, phoneNumberOrEmail)).thenReturn(Optional.of(patient));

		PatientDto result = patientService.getPatientByPhoneNumberOrEmail(phoneNumberOrEmail);

		assertNotNull(result);
		// Add assertions based on your mapping logic
	}

	@Test
	void testGetAllPatients() {
		List<Patient> patients = new ArrayList<>();
		patients.add(new Patient());
		patients.add(new Patient());
		when(patientRepository.findAll()).thenReturn(patients);

		List<PatientDto> result = patientService.getAllPatients();

		assertNotNull(result);
		assertEquals(patients.size(), result.size());
		// Add assertions based on your mapping logic
	}

	@Test
	void testCreatePatient() {
		PatientDto patientDto = new PatientDto();
		patientDto.setEmail("test@example.com");
		patientDto.setPhoneNumber("1234567890");
		when(patientRepository.getPatientByPhoneNumber(patientDto.getPhoneNumber())).thenReturn(Optional.empty());
		when(patientRepository.getPatientByEmail(patientDto.getEmail())).thenReturn(Optional.empty());

		Patient savedPatient = new Patient();
		savedPatient.setId(1L);
		when(patientRepository.save(any())).thenReturn(savedPatient);

		PatientDto result = patientService.createPatient(patientDto);

		assertNotNull(result);
		assertEquals(savedPatient.getId(), result.getId());
		// Add more assertions based on your mapping logic
		verify(identityManagementServiceUtil, times(1)).save(any());
	}

	@Test
	void testCreatePatient_PhoneNumberAlreadyExists() {
		PatientDto patientDto = new PatientDto();
		patientDto.setPhoneNumber("1234567890");
		when(patientRepository.getPatientByPhoneNumber(patientDto.getPhoneNumber())).thenReturn(Optional.of(new Patient()));

		assertThrows(PhoneNumberAlreadyExistsException.class, () -> patientService.createPatient(patientDto));
		verify(patientRepository, never()).getPatientByEmail(any());
		verify(patientRepository, never()).save(any());
		verify(identityManagementServiceUtil, never()).save(any());
	}
}
