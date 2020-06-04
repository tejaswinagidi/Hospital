import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PatientListComponent } from './patient-list/patient-list.component';
import { GetPatientListService } from './get-patient-list.service';
import { HttpClientModule } from '@angular/common/Http';

const appRoutes: Routes=[
  {path: 'patient-list', component: PatientListComponent},
  {path: '', redirectTo:'/patient-list',pathMatch:'full'}

]
@NgModule({
  declarations: [
    AppComponent,
    PatientListComponent,
 
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [ GetPatientListService],
  bootstrap: [AppComponent]
})
export class AppModule { }
