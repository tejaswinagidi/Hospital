package com.miniproject.Hospital.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.Hospital.Entity.Patient;
import com.miniproject.Hospital.Repository.PatientRepository;

@Service
public class PatientService {
	
	 @Autowired
	    private PatientRepository repository;

         //returns list of all patients
	 public List<Patient> findAllPatients() {
		 return (List<Patient>) repository.findAll();
	    }

         //return particular patient with given patientId
	 public Patient findByPatientId(int id) {
		 if((repository.findById(id).isPresent())){
	        return repository.findById(id).get();
	    }
		 else
			 return null;
	 }

         //delete particular patient with given patientId from list
	 public void deleteByPatientId(int id) {
	        repository.deleteById(id);
	    }
	
         //adds new patient to list
	 public void addNewPatients(Patient patient) {
		 repository.save(patient);
            }
	 
}
