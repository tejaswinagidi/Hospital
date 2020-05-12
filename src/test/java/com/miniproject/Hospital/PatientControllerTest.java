package com.miniproject.Hospital;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.miniproject.Hospital.Entity.Patient;
import com.miniproject.Hospital.Repository.PatientRepository;
import com.miniproject.Hospital.Service.PatientService;


public class PatientControllerTest extends AbstractTest {
    @MockBean PatientService patientService;
    @MockBean PatientRepository patientRepository;

    
	@Override
   @Before
   public void setUp() {
      super.setUp();
   }
	public Patient patientObject(int patientId,String firstName,String lastName,int age,String gender,String emailId,long mobileNumber,String sympthoms) {
	      Patient patient = new Patient();
	      patient.setPatientId(patientId);
	      patient.setFirstName(firstName);
	      patient.setLastName(lastName);
	      patient.setAge(age);
	      patient.setGender(gender);
	      patient.setEmailid(emailId);
	      patient.setMobileNumber(mobileNumber);
	      patient.setSymptoms(sympthoms);
	      return patient;
	}
   @Test
   public void findAllPatientsTest() throws Exception {
      String uri = "/findAllPatients";
      List<Patient> patients=new ArrayList<Patient>();
      patients.add(patientObject(3,"teja","yoshi",19,"f","tejaswi.mail.com",782908772,"nnone"));
      patients.add(patientObject(5,"teja","yoshi",19,"f","tejswi.mail.com",78208772,"nnone"));
      Mockito.when(patientService.findAllPatients()).thenReturn(patients);
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk()).andReturn();
      String content = mvcResult.getResponse().getContentAsString();
      Patient[] patienttlist = super.mapFromJson(content, Patient[].class);
      Mockito.verify(patientService, Mockito.times(1)).findAllPatients();
      assertThat(patienttlist.length,is(2));
   }
   @Test
   public void addNewPatientTest() throws Exception {
      String uri = "/addNewPatients";
      Patient patient =(patientObject(3,"teja","yoshi",19,"f","tejaswi.mail.com",782908772,"nnone"));;
      String inputJson = super.mapToJson(patient);
      mvc.perform(MockMvcRequestBuilders.post(uri)
         .contentType(MediaType.APPLICATION_JSON_VALUE)
         .content(inputJson)).andExpect(status().isCreated()).andReturn();
      
      Mockito.verify(patientService, Mockito.times(1)).addNewPatients(any());
   } 
   @Test
   public void deleteByPatientIdTest() throws Exception {
	      String uri = "/deleteByPatientId/3";
          mvc.perform(MockMvcRequestBuilders.delete(uri)).andExpect(status().isNoContent()).andReturn();
	      Mockito.verify(patientService, Mockito.times(1)).deleteByPatientId(anyInt());

	   }
  
   
   
}
