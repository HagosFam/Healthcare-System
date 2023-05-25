import { Component, OnInit, ViewChild} from '@angular/core';
import { Patient } from '../models/Patient';
import { PatientService } from '../service/patient.service';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: 'app-patient-management',
  templateUrl: './patient-management.component.html',
  styleUrls: ['./patient-management.component.css']
})
export class PatientManagementComponent implements OnInit {
  patients: Patient[] = new Array();
  displayedColumns: string[] = ['firstName', 'lastName', 'phoneNumber','insuranceId','email','address','street','city','state','zipCode', 'edit', 'delete'];

  patient:Patient[] = new Array()
  @ViewChild(MatSort)
  sort!: MatSort;
  @ViewChild(MatPaginator)
  paginator!: MatPaginator;
  dataSource: any


  constructor(private patientService: PatientService, private toastr:ToastrService) { }

  ngOnInit() {
    this.getPatients();
  }

  getPatients() {
    this.patientService.getPatients().subscribe((res) => {
      if (res!=null) {
       this.toastr.success('All appointments loaded');
        this.patient = res
        this.dataSource = new MatTableDataSource(this.patient);
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
  updatePatient(patient: Patient) {
    this.patientService.updatePatient(patient)
      .subscribe(
        updatedPatient => {
          const index = this.patients.findIndex(p => p.id === updatedPatient.id);
          if (index !== -1) {
            this.patients[index] = updatedPatient;
          }
          console.log('Patient updated successfully.');
        },
        error => console.log(error)
      );
  }

  deletePatient(id: number) {
    this.patientService.deletePatient(id)
      .subscribe(
        () => {
          this.patients = this.patients.filter(p => p.id !== id);
          console.log('Patient deleted successfully.');
        },
        error => console.log(error)
      );
  }
}
