import { Component } from '@angular/core';
import { appointment } from '../models/appointment';
import { AppointmentService } from '../service/appointment.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

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
    patientId: new FormControl(null, Validators.required),
    appointmentDate: new FormControl('', Validators.required),
    doctorId: new FormControl(null, Validators.required),
    roomNumber: new FormControl('')
  });
  

  constructor(private appointmentService: AppointmentService, private formBuilder:FormBuilder) {}

  ngOnInit(): void {
  }


  // Create an appointment
  createAppointment(): void {
    if (this.appointmentForm.valid) {
      const newAppointment: appointment = { ...this.appointmentForm.value };
      this.appointmentService.createAppointment(newAppointment).subscribe(
        (createdAppointment: appointment) => {
          console.log('Appointment created:', createdAppointment);
          // Optionally, you can perform any additional logic after creating the appointment
          // For example, you can update the local appointments list or show a success message
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
