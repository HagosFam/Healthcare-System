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
  displayedColumns: string[] = ['id', 'patientId', 'servicesRendered','paymentId','amount', 'paymentDate', 'edit', 'delete'];

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
  editBilling(data:any) {

  }

  deleteBilling(data:any) {

  }
}
