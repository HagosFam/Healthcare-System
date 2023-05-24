import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BillingPaymentManagementComponent } from './billing-payment-management.component';

describe('BillingPaymentManagementComponent', () => {
  let component: BillingPaymentManagementComponent;
  let fixture: ComponentFixture<BillingPaymentManagementComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BillingPaymentManagementComponent]
    });
    fixture = TestBed.createComponent(BillingPaymentManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
