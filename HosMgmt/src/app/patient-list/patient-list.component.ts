import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent implements OnInit {

  constructor() { }

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
