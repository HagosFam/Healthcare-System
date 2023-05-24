import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppointmentHomeComponent } from './appointment-service/appointment-home/appointment-home.component';
import { AppComponent } from './app.component';
import { CreateAppointmentComponent } from './appointment-service/create-appointment/create-appointment.component';
import { HomePageComponent } from './home-page/home-page.component';
import { AppointmentMgtComponent } from './appointment-service/appointment-mgt/appointment-mgt.component';
import { BillingPaymentManagementComponent } from './billing-payment-service/billing-payment-management/billing-payment-management.component';
import { CreateBillingPaymentComponent } from './billing-payment-service/create-billing-payment/create-billing-payment.component';
import { CreateEmrComponent } from './emr-service/create-emr/create-emr.component';
import { EmrManagementComponent } from './emr-service/emr-management/emr-management.component';
import { CreatePatientComponent } from './patient-service/create-patient/create-patient.component';
import { PatientManagementComponent } from './patient-service/patient-management/patient-management.component';

const appRoutes: Routes = [
  {path:'', component: HomePageComponent},
  { path: 'appointment', component: AppointmentMgtComponent },
  { path: 'createAppointment', component: CreateAppointmentComponent },
 
  { path: 'billingmgt', component: BillingPaymentManagementComponent },
  { path: 'createbilling', component: CreateBillingPaymentComponent },


  { path: 'createEMR', component: CreateEmrComponent },
  { path: 'EMRMgt', component: EmrManagementComponent },


  { path: 'createPatient', component: CreatePatientComponent },
  { path: 'patientMgt', component: PatientManagementComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
