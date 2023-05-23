import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppointmentHomeComponent } from './appointment-service/appointment-home/appointment-home.component';
import { AppComponent } from './app.component';
import { CreateAppointmentComponent } from './appointment-service/create-appointment/create-appointment.component';
import { HomePageComponent } from './home-page/home-page.component';
import { AppointmentMgtComponent } from './appointment-service/appointment-mgt/appointment-mgt.component';

const appRoutes: Routes = [
  {path:'', component: HomePageComponent},
  { path: 'appointment', component: AppointmentMgtComponent },
  { path: 'createAppointment', component: CreateAppointmentComponent },
  { path: 'appointment', component: AppointmentHomeComponent },
  { path: 'appointment', component: AppointmentHomeComponent },
  { path: 'appointment/management', component: CreateAppointmentComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
