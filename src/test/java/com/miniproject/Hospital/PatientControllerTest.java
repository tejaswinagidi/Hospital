package com.miniproject.Hospital;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.miniproject.Hospital.Entity.Patient;


public class PatientControllerTest extends AbstractTest {
   @Override
   @Before
   public void setUp() {
      super.setUp();
   }
   @Test
   public void findAllPatientsTest() throws Exception {
      String uri = "/findAllPatients";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      Patient[] patienttlist = super.mapFromJson(content, Patient[].class);
      assertTrue(patienttlist.length > 0);
   }
   @Test
   public void addNewPatientTest() throws Exception {
      String uri = "/AddNewPatient";
      Patient patient = new Patient();
      patient.setPatientId(3);
      patient.setFirstName("teja");
      patient.setLastName("ramani");
      patient.setAge(22);
      patient.setGender("f");
      patient.setEmailid("teja.nagidi.hcl.com");
      patient.setMobileNumber(836278910);
      patient.setSymptoms("none");
      String inputJson = super.mapToJson(patient);
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
         .contentType(MediaType.APPLICATION_JSON_VALUE)
         .content(inputJson)).andReturn();
      int status = mvcResult.getResponse().getStatus();
      assertEquals(201, status);
      String content = mvcResult.getResponse().getContentAsString();
      assertEquals(content, "CREATED");
   } 
   @Test
   public void deleteByPatientId() throws Exception {
	      String uri = "/deleteByPatientId/2";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "OK");
	   }
   @Test
   public void findByPatientId() throws Exception {
	      String uri = "/findByPatientId/2";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "OK");
	   }
   
   
}
