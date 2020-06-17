package com.miniproject.Hospital.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.google.gson.Gson;
import com.miniproject.Hospital.Entity.Patient;
import com.miniproject.Hospital.Service.PatientService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PatientController {
	
	 @Autowired
	    private PatientService service;
	 
	//returns list of all patients saved
	 @RequestMapping(path="/findAllPatients",method=RequestMethod.GET,produces= {"application/json"}) 
	 public ResponseEntity<String> findAllPatients(){
		List<Patient> patients=service.findAllPatients();		
		Gson gson = new Gson();
		return new ResponseEntity<>(gson.toJson(patients), HttpStatus.OK);
	 }
	 
	//returns the patient details with given patientId
	 @RequestMapping(path="/findByPatientId/{id}", method = RequestMethod.GET)
		public ResponseEntity<String> findByPatientId(@PathVariable(value="id") int id) {
			Patient patient=service.findByPatientId(id);
			Gson gson = new Gson();
			return new ResponseEntity<>(gson.toJson(patient), HttpStatus.OK);
		}
	
	 //delete the particular patient with given patientId
	 @RequestMapping(path="/deleteByPatientId/{id}")
	 public ResponseEntity<String> deleteByPatientId(@PathVariable(value="id") int id) {
		 Patient patient=service.findByPatientId(id);
	//	 System.out.println(patient);
		 if(null!=patient) {
		 service.deleteByPatientId(id);
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	     }
		 else {
				Gson gson = new Gson();
				return new ResponseEntity<>(gson.toJson("Patient not found"), HttpStatus.NOT_FOUND);
	     }
	 }
	 //add a new patient into database
	 @PostMapping(path="/addNewPatients") 
	 public ResponseEntity<String> addNewPatient(@RequestBody Patient patient){
		 service.addNewPatients(patient);
	     return new ResponseEntity<>(HttpStatus.CREATED);
	 }
	 
	 
}
