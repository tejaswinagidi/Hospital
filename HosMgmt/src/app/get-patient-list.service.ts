import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/Http';
import {patient} from './patient';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GetPatientListService {
  constructor(private http:HttpClient ) { }

  getAllPatients(): Observable<patient[]>{
      return this.http.get<patient[]>("//localhost:8080/findAllPatients");
      
  }
}
