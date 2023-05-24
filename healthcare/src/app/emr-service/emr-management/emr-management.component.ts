import { Component, ViewChild } from '@angular/core';
import { MedicalRecordService } from '../service/medical-record.service';
import { DiagnosisReportService } from '../service/diagnosis-report.service';
import { MedicalRecord } from '../models/MedicalRecord';
import { DiagnosisReport } from '../models/DiagnosisReport';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { ToastrService } from 'ngx-toastr';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-emr-management',
  templateUrl: './emr-management.component.html',
  styleUrls: ['./emr-management.component.css']
})
export class EmrManagementComponent {
  medicalRecords: MedicalRecord[] = [];
  diagnosisReports: DiagnosisReport[] = [];
  selectedMedicalRecord: MedicalRecord | null = null;
  displayedColumns: string[] = ['id', 'patient', 'date', 'doctor','roomNumber', 'edit', 'delete'];
  medicalreport:MedicalRecord[] = new Array()
  @ViewChild(MatSort)
  sort!: MatSort;
  @ViewChild(MatPaginator)
  paginator!: MatPaginator;
  dataSource: any


  constructor(
    private medicalRecordService: MedicalRecordService,
    private diagnosisReportService: DiagnosisReportService,
    private toastr:ToastrService
  ) {}

  ngOnInit() {
    this.fetchAllMedicalReports();
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


  fetchAllMedicalReports() {
    this.medicalRecordService.getAllMedicalRecords().subscribe((res) => {
      if (res!=null) {
        this.toastr.success('All medical reports loaded');
        this.medicalRecords = res
        this.dataSource = new MatTableDataSource(this.medicalRecords);
        console.log(this.dataSource);
        this.dataSource.sort = this.sort;
        setTimeout(() => this.dataSource.paginator = this.paginator);
      } else {
        console.log("Can's save data");
      }
    }, (err) => {
      console.log("error occured")
    }
    );
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
      this.fetchAllMedicalReports();
    });
  }

  // Delete a medical record
  deleteMedicalRecord(record: MedicalRecord) {
    if (confirm('Are you sure you want to delete this medical record?')) {
      this.medicalRecordService.deleteMedicalRecord(record.id).subscribe(() => {
        this.fetchAllMedicalReports();
        this.selectedMedicalRecord = null;
        this.diagnosisReports = [];
      });
    }
  }

}
