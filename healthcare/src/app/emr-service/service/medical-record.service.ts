import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MedicalRecord } from '../models/MedicalRecord';

@Injectable({
  providedIn: 'root'
})
export class MedicalRecordService {
  private baseUrl = 'api/medical-records'; // Replace with your API endpoint

  constructor(private http: HttpClient) {}

  // Create a new medical record
  createMedicalRecord(record: MedicalRecord): Observable<MedicalRecord> {
    return this.http.post<MedicalRecord>(this.baseUrl, record);
  }

    // Get all medical records
    getAllMedicalRecords(): Observable<MedicalRecord[]> {
      return this.http.get<MedicalRecord[]>(this.baseUrl);
    }

  // Get a specific medical record by ID
  getMedicalRecordById(id: number): Observable<MedicalRecord> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.get<MedicalRecord>(url);
  }

  // Update an existing medical record
  updateMedicalRecord(record: MedicalRecord): Observable<MedicalRecord> {
    const url = `${this.baseUrl}/${record.id}`;
    return this.http.put<MedicalRecord>(url, record);
  }

  // Delete a medical record by ID
  deleteMedicalRecord(id: number): Observable<void> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.delete<void>(url);
  }
}
