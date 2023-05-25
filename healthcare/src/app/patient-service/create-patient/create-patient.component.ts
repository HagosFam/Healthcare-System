import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { PatientService } from '../service/patient.service';
import { Patient } from '../models/Patient';

@Component({
  selector: 'app-create-patient',
  templateUrl: './create-patient.component.html',
  styleUrls: ['./create-patient.component.css']
})
export class CreatePatientComponent implements OnInit {
  patientForm!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private patientService: PatientService
  ) { }

  ngOnInit(): void {
    this.patientForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      phoneNumber: ['', Validators.required],
      insuranceId: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      address: this.formBuilder.group({
        street: ['', Validators.required],
        city: ['', Validators.required],
        state: ['', Validators.required],
        zipCode: ['', Validators.required]
      })
    });
  }

  get address(): FormGroup {
    return this.patientForm.get('address') as FormGroup;
  }
  
  get street(): FormControl {
    return this.address.get('street') as FormControl;
  }
  
  get city(): FormControl {
    return this.address.get('city') as FormControl;
  }
  
  get state(): FormControl {
    return this.address.get('state') as FormControl;
  }
  
  get zipCode(): FormControl {
    return this.address.get('zipCode') as FormControl;
  }
  
  

  get formControls() {
    return this.patientForm.controls;
  }

  onSubmit() {

    console.log("data coming")
    console.log(this.patientForm.value)

    if (this.patientForm.invalid) {
      return;
    }

    const patient: Patient = this.patientForm.value;
    this.patientService.createPatient(patient)
      .subscribe(
        newPatient => {
          console.log('Patient created successfully.');
          this.patientForm.reset();
        },
        error => console.log(error)
      );
  }
}

