import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InsuranceManagementComponent } from './insurance-management.component';

describe('InsuranceManagementComponent', () => {
  let component: InsuranceManagementComponent;
  let fixture: ComponentFixture<InsuranceManagementComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [InsuranceManagementComponent]
    });
    fixture = TestBed.createComponent(InsuranceManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
