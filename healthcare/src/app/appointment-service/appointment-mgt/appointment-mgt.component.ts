import { Component, ViewChild } from '@angular/core';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import { appointment } from '../models/appointment';
import { AppointmentService } from '../service/appointment.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-appointment-mgt',
  templateUrl: './appointment-mgt.component.html',
  styleUrls: ['./appointment-mgt.component.css']
})
export class AppointmentMgtComponent {
  displayedColumns: string[] = ['id', 'patient', 'date', 'doctor','roomNumber', 'edit', 'delete'];
  appointments:appointment[] = new Array()
  @ViewChild(MatSort)
  sort!: MatSort;
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  dataSource = new MatTableDataSource<any>([]);

  constructor(private appointmentService:AppointmentService, private toastr:ToastrService) {  }
  
  ngOnInit(){
    this.fetchAllAppointments();
  }

  fetchAllAppointments() {
    this.appointmentService.getAppointments().subscribe((res) => {
      if (res!=null) {
        this.toastr.success('All appointments loaded');
        this.appointments = res
        console.log(this.appointments)
        this.dataSource = new MatTableDataSource(this.appointments);
        this.dataSource.sort = this.sort;
         this.dataSource.paginator = this.paginator;
      } else {
        console.log("Can's save data");
      }
    }, (err) => {
      console.log("error occured")
    }
    );
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

    // Delete an appointment
    deleteAppointment(appointmentId: any): void {
      if(confirm("Are you sure you want to delete this data?")){
this.appointmentService.deleteAppointment(appointmentId).subscribe(
        () => {
          this.toastr.error("Appointment deleted successfully! ");
          // Optionally, you can perform any additional logic after deleting the appointment
        },
        (error: any) => {
          this.toastr.error("Error in deleting appointment");
          // Handle any error that occurred during the deletion of the appointment
        }
      );
      }
    }


}
