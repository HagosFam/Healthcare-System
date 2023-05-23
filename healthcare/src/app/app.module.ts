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
import { FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent, 
    AppointmentHomeComponent, 
    AppointmentMgtComponent, CreateAppointmentComponent, HomePageComponent],
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



    RouterModule,
    AppRoutingModule,
  ],
  providers: [],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  bootstrap: [AppComponent]
})
export class AppModule { }
