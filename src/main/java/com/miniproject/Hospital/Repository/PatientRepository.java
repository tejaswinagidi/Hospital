package com.miniproject.Hospital.Repository;

import org.springframework.data.repository.CrudRepository;

import com.miniproject.Hospital.Entity.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer> {

}
