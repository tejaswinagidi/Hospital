import { Component, OnInit } from '@angular/core';
import {patient} from '../patient';
import { GetPatientListService } from '../get-patient-list.service';

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent implements OnInit {
  patients : patient[];

  constructor(private patientList : GetPatientListService) {
   }

  ngOnInit(): void {

    this.patientList.getAllPatients().subscribe(data => this.patients=data)
   
  }
 
  
}
