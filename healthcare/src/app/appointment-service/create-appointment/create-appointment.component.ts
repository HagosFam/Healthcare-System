import { Component } from '@angular/core';
import { appointment } from '../models/appointment';
import { AppointmentService } from '../service/appointment.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { PatientService } from 'src/app/patient-service/service/patient.service';
import { Patient } from 'src/app/patient-service/models/Patient';


@Component({
  selector: 'app-create-appointment',
  templateUrl: './create-appointment.component.html',
  styleUrls: ['./create-appointment.component.css']
})
export class CreateAppointmentComponent {
  appointment:appointment = new appointment;
  appointments: appointment[] = [];
  appointmentForm: FormGroup = new FormGroup({
    appointmentId: new FormControl(null),
    patientId: new FormControl(''),
    appointmentDate: new FormControl(''),
    doctorId: new FormControl(''),
    roomNumber: new FormControl('')
  });
  

  constructor(private appointmentService: AppointmentService, private formBuilder:FormBuilder, private toastr:ToastrService, private patientService: PatientService) {}

  patients: Patient[] = new Array();


  ngOnInit() {
    this.getPatients();
  }

  getPatients() {
    this.patientService.getPatients()
      .subscribe(
        patients => this.patients = patients,
        error => console.log(error)
      );
  }


  // Create an appointment
  createAppointment(): void {
    
    if (this.appointmentForm.valid) {
      const newAppointment: appointment = { ...this.appointmentForm.value };
      newAppointment.id=1;
      newAppointment.date="12/11/23";
      console.log("arrived")
      this.appointmentService.createAppointment(newAppointment).subscribe(
        (createdAppointment: appointment) => {
          this.toastr.success("Appointment created successfully!");
          console.log('Appointment created:', createdAppointment);
        
          this.appointmentForm.reset(); // Reset the form after successful submission
        },
        (error: any) => {
          console.error('Error creating appointment:', error);
          // Handle any error that occurred during the creation of the appointment
        }
      );
    } else {
      // Form is invalid, display validation errors or handle the error as per your requirement
    }
  }
  
  

}
