import { Component, OnInit } from '@angular/core';
import { DiagnosisReport } from '../models/DiagnosisReport';
import { MedicalRecord } from '../models/MedicalRecord';
import { DiagnosisReportService } from '../service/diagnosis-report.service';
import { MedicalRecordService } from '../service/medical-record.service';

@Component({
  selector: 'app-medical-record',
  templateUrl: './medical-record.component.html',
  styleUrls: ['./medical-record.component.css']
})
export class MedicalReportComponent implements OnInit {
  medicalRecords: MedicalRecord[] = [];
  diagnosisReports: DiagnosisReport[] = [];
  selectedMedicalRecord: MedicalRecord | null = null;

  constructor(
    private medicalRecordService: MedicalRecordService,
    private diagnosisReportService: DiagnosisReportService
  ) {}

  ngOnInit() {
    this.loadMedicalRecords();
  }

  // Load all medical records
  loadMedicalRecords() {
    this.medicalRecordService.getAllMedicalRecords().subscribe(records => {
      this.medicalRecords = records;
    });
  }

  // Load diagnosis reports for a specific medical record
  loadDiagnosisReports(medicalRecord: MedicalRecord) {
    this.selectedMedicalRecord = medicalRecord;
    this.diagnosisReportService
      .getDiagnosisReportsByPatientId(medicalRecord.patientId)
      .subscribe(reports => {
        this.diagnosisReports = reports;
      });
  }

  // Create a new medical record
  createMedicalRecord() {
    const newRecord: MedicalRecord = {
      id: 0,
      patientId: 0,
      diagnosisReports: [],
      laboratoryReports: [],
      allergy: [""]
    };
    this.medicalRecordService.createMedicalRecord(newRecord).subscribe(() => {
      this.loadMedicalRecords();
    });
  }

  // Delete a medical record
  deleteMedicalRecord(record: MedicalRecord) {
    if (confirm('Are you sure you want to delete this medical record?')) {
      this.medicalRecordService.deleteMedicalRecord(record.id).subscribe(() => {
        this.loadMedicalRecords();
        this.selectedMedicalRecord = null;
        this.diagnosisReports = [];
      });
    }
  }
}
