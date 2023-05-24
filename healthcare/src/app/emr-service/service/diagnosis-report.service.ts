import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { DiagnosisReport } from '../models/DiagnosisReport';


@Injectable({
  providedIn: 'root'
})
export class DiagnosisReportService {
  private baseUrl = 'api/diagnosis-reports'; // Replace with your API endpoint

  constructor(private http: HttpClient) {}

  // Create a new diagnosis report
  createDiagnosisReport(report: DiagnosisReport): Observable<DiagnosisReport> {
    return this.http.post<DiagnosisReport>(this.baseUrl, report);
  }

  // Get a specific diagnosis report by ID
  getDiagnosisReportById(id: number): Observable<DiagnosisReport> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.get<DiagnosisReport>(url);
  }

  // Update an existing diagnosis report
  updateDiagnosisReport(report: DiagnosisReport): Observable<DiagnosisReport> {
    const url = `${this.baseUrl}/${report.id}`;
    return this.http.put<DiagnosisReport>(url, report);
  }

  // Delete a diagnosis report by ID
  deleteDiagnosisReport(id: number): Observable<void> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.delete<void>(url);
  }
  
  // Get all diagnosis reports for a specific patient ID
  getDiagnosisReportsByPatientId(patientId: number): Observable<DiagnosisReport[]> {
    const url = `${this.baseUrl}/patient/${patientId}`;
    return this.http.get<DiagnosisReport[]>(url);
  }
}
