import { Component, OnInit } from '@angular/core';
import { GetPatientListService } from '../get-patient-list.service';

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent implements OnInit {
  public patients=[]
  constructor( patientList : GetPatientListService) {
   }

  ngOnInit(): void {
   
  }
  patientId:number;
  firstName:String;
  lastName:String;
  age:number;
  gender:String;
  emailId:String;
  mobileNumber:number;
  symptoms:String;
  
}
