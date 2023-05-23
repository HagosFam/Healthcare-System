// app.module.ts

import { BrowserModule } from '@angular/platform-browser';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import {MatSidenavModule} from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import {MatTableModule} from '@angular/material/table';
import { MatSortModule } from '@angular/material/sort';
import { MatPaginatorModule } from '@angular/material/paginator';
import { AppComponent } from './app.component';
import { AppointmentHomeComponent } from './appointment-service/appointment-home/appointment-home.component';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { CreateAppointmentComponent } from './appointment-service/create-appointment/create-appointment.component';
import { HomePageComponent } from './home-page/home-page.component';
import { AppointmentMgtComponent } from './appointment-service/appointment-mgt/appointment-mgt.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BillingPaymentManagementComponent } from './billing-payment-service/billing-payment-management/billing-payment-management.component';
import { CreateBillingPaymentComponent } from './billing-payment-service/create-billing-payment/create-billing-payment.component';
import { EmrManagementComponent } from './emr-service/emr-management/emr-management.component';
import { CreateEmrComponent } from './emr-service/create-emr/create-emr.component';
import { InsuranceManagementComponent } from './insurance-service/insurance-management/insurance-management.component';
import { CreateInsuranceComponent } from './insurance-service/create-insurance/create-insurance.component';
import { PatientManagementComponent } from './patient-service/patient-management/patient-management.component';
import { CreatePatientComponent } from './patient-service/create-patient/create-patient.component';
import { PrescriptionManagementComponent } from './prescription-service/prescription-management/prescription-management.component';
import { CreatePrescriptionComponent } from './prescription-service/create-prescription/create-prescription.component';
import { ToastrModule } from 'ngx-toastr';
import { CreateDignosisComponent } from './emr-service/create-dignosis/create-dignosis.component';
import { LaboratoryReportComponent } from './emr-service/laboratory-report/laboratory-report.component';

@NgModule({
  declarations: [
    AppComponent, 
    AppointmentHomeComponent, 
    AppointmentMgtComponent, CreateAppointmentComponent, HomePageComponent, BillingPaymentManagementComponent, CreateBillingPaymentComponent, EmrManagementComponent, CreateEmrComponent, InsuranceManagementComponent, CreateInsuranceComponent, PatientManagementComponent, CreatePatientComponent, PrescriptionManagementComponent, CreatePrescriptionComponent, CreateDignosisComponent, LaboratoryReportComponent],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatInputModule,
    MatTableModule,
    MatFormFieldModule,
    MatSelectModule,
    MatMenuModule,
    MatSortModule,
    MatPaginatorModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    ToastrModule.forRoot(),

    RouterModule,
    AppRoutingModule,
  ],
  providers: [],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  bootstrap: [AppComponent]
})
export class AppModule { }
