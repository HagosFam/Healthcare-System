import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { appointment } from '../models/appointment';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {
  private apiUrl = 'http://localhost:8060/api/v1/appointments';

  constructor(private http: HttpClient) { }

  // Create an appointment
  createAppointment(newAppointment: appointment): Observable<appointment> {
    return this.http.post<appointment>(this.apiUrl, newAppointment);
  }

  // Read all appointments
  getAppointments(): Observable<appointment[]> {
    return this.http.get<appointment[]>(this.apiUrl  );
  }

  // Read a specific appointment by ID
  getAppointmentById(appointmentId: any): Observable<appointment> {
    const url = `${this.apiUrl}/${appointmentId}`;
    return this.http.get<appointment>(url);
  }

  // Update an appointment
  updateAppointment(updatedAppointment: appointment): Observable<appointment> {
    const url = `${this.apiUrl}/${updatedAppointment.appointmentId}`;
    return this.http.put<appointment>(url, updatedAppointment);
  }

  // Delete an appointment
  deleteAppointment(appointmentId: any): Observable<void> {
    const url = `${this.apiUrl}/${appointmentId}`;
    return this.http.delete<void>(url);
  }
}
