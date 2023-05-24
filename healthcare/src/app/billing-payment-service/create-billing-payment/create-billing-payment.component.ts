import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormArray, Validators } from '@angular/forms';
import { BillingService } from '../service/billing.service';
import { Bill } from '../models/Bill';


@Component({
  selector: 'app-create-billing-payment',
  templateUrl: './create-billing-payment.component.html',
  styleUrls: ['./create-billing-payment.component.css']
})
export class CreateBillingPaymentComponent implements OnInit {
  billForm!: FormGroup;

  constructor(private fb: FormBuilder, private billService: BillingService) { }

  ngOnInit(): void {
    this.createBillForm();
  }

  createBillForm(): void {
    this.billForm = this.fb.group({
      patientId: ['', Validators.required],
      servicesRendered: '',
      payment: this.fb.array([this.createPaymentGroup()])
    });
  }

  createPaymentGroup(): FormGroup {
    return this.fb.group({
      paymentDate: '',
      id: '',
      amount: ''
    });
  }

  get paymentArray(): FormArray {
    return this.billForm.get('payment') as FormArray;
  }

  addPayment(): void {
    this.paymentArray.push(this.createPaymentGroup());
  }

  removePayment(index: number): void {
    this.paymentArray.removeAt(index);
  }

  createBill(): void {
    if (this.billForm.invalid) {
      return;
    }

    const bill: Bill = this.billForm.value;
    this.billService.createBill(bill).subscribe(
      (createdBill: Bill) => {
        console.log('New bill created:', createdBill);
        this.billForm.reset();
      },
      (error) => {
        console.error('Error occurred while creating bill:', error);
      }
    );
  }
}

