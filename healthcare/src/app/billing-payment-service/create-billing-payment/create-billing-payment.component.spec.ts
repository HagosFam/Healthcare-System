import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateBillingPaymentComponent } from './create-billing-payment.component';

describe('CreateBillingPaymentComponent', () => {
  let component: CreateBillingPaymentComponent;
  let fixture: ComponentFixture<CreateBillingPaymentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreateBillingPaymentComponent]
    });
    fixture = TestBed.createComponent(CreateBillingPaymentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
