package com.smartdroffice.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.smartdroffice.domain.Patient;

public interface PatientRepository extends CrudRepository<Patient, BigInteger>{
	Patient findByPatientId(BigInteger patientid);
	List<Patient> findPatientsByClientId(BigInteger clientId);
	Patient save(Patient patient);
}
