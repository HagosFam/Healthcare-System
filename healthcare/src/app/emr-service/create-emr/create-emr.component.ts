import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormArray } from '@angular/forms';
import { MedicalRecordService } from '../service/medical-record.service';
import { MedicalRecord } from '../models/MedicalRecord';


@Component({
  selector: 'app-create-emr',
  templateUrl: './create-emr.component.html',
  styleUrls: ['./create-emr.component.css']
})
export class CreateEmrComponent implements OnInit {
  medicalRecordForm!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private medicalRecordService: MedicalRecordService
  ) {}

  ngOnInit() {
    this.initForm();
  }

  initForm() {
    this.medicalRecordForm = this.formBuilder.group({
      patientId: [0, Validators.required],
      allergy: [''],
      diagnosisReports: this.formBuilder.array([]),
      laboratoryReports: this.formBuilder.array([])
    });
  }

  get diagnosisReports(): FormArray {
    return this.medicalRecordForm.get('diagnosisReports') as FormArray;
  }

  get laboratoryReports(): FormArray {
    return this.medicalRecordForm.get('laboratoryReports') as FormArray;
  }

  addDiagnosisReport() {
    const diagnosisReportFormGroup = this.formBuilder.group({
      id: 0,
      patientId: 0,
      doctorId: 0,
      diagnosisCode: '',
      recommendation: '',
      prescriptionId: 0
    });

    this.diagnosisReports.push(diagnosisReportFormGroup);
  }

  addLaboratoryReport() {
    const laboratoryReportFormGroup = this.formBuilder.group({
      id: 0,
      patientId: 0,
      reportType: '',
      result: ''
    });

    this.laboratoryReports.push(laboratoryReportFormGroup);
  }


  removeDiagnosisReport(index: number) {
    this.diagnosisReports.removeAt(index);
  }

  removeLaboratoryReport(index: number) {
    this.laboratoryReports.removeAt(index);
  }

  saveMedicalRecord() {
    if (this.medicalRecordForm.valid) {
      const medicalRecord: MedicalRecord = {
        id: 0,
        patientId: this.medicalRecordForm.value.patientId,
        diagnosisReports: this.medicalRecordForm.value.diagnosisReports,
        laboratoryReports: this.medicalRecordForm.value.laboratoryReports,
        allergy: [this.medicalRecordForm.value.allergy],
      };

      this.medicalRecordService.createMedicalRecord(medicalRecord).subscribe(() => {
        // Record saved successfully
        this.medicalRecordForm.reset();
        this.clearFormArray(this.diagnosisReports);
        this.clearFormArray(this.laboratoryReports);
      });
    }
  }

  clearFormArray(formArray: FormArray) {
    while (formArray.length !== 0) {
      formArray.removeAt(0);
    }
  }
}
