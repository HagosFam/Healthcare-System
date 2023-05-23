import { Component, OnInit, ViewChild } from '@angular/core';
import { BillingService } from '../service/billing.service';
import { Bill } from '../models/Bill';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';


@Component({
  selector: 'app-billing-payment-management',
  templateUrl: './billing-payment-management.component.html',
  styleUrls: ['./billing-payment-management.component.css']
})
export class BillingPaymentManagementComponent implements OnInit {
  bills: Bill[] = [];
  displayedColumns: string[] = ['id', 'patient', 'date', 'doctor','roomNumber', 'edit', 'delete'];
  @ViewChild(MatSort)
  sort!: MatSort;
  @ViewChild(MatPaginator)
  paginator!: MatPaginator;
  dataSource: any

  constructor(private billService: BillingService) { }

  ngOnInit(): void {
    this.loadBills();
  }

  loadBills() {
    this.billService.getAllBills().subscribe((res) => {
      if (res!=null) {
        this.bills = res
        this.dataSource = new MatTableDataSource(this.bills);
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

  createBill(): void {
    const newBill: Bill = {
      id: null, // Set to null or omit if generating ID on the server
      patientId: 'patient123',
      servicesRendered: 'Service 1, Service 2',
      payment: []
    };

    this.billService.createBill(newBill).subscribe(
      (bill: Bill) => {
        console.log('New bill created:', bill);
        this.loadBills(); // Refresh the bill list after creating a new bill
      },
      (error) => {
        console.error('Error occurred while creating bill:', error);
      }
    );
  }

  updateBill(bill: Bill): void {
    this.billService.updateBill(bill).subscribe(
      (updatedBill: Bill) => {
        console.log('Bill updated:', updatedBill);
        // Handle success, if needed
      },
      (error) => {
        console.error('Error occurred while updating bill:', error);
      }
    );
  }

  deleteBill(id: any): void {
    this.billService.deleteBill(id).subscribe(
      () => {
        console.log('Bill deleted');
        this.loadBills(); // Refresh the bill list after deleting a bill
      },
      (error) => {
        console.error('Error occurred while deleting bill:', error);
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
}
