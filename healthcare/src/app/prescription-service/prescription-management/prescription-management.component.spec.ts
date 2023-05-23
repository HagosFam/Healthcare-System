import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrescriptionManagementComponent } from './prescription-management.component';

describe('PrescriptionManagementComponent', () => {
  let component: PrescriptionManagementComponent;
  let fixture: ComponentFixture<PrescriptionManagementComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PrescriptionManagementComponent]
    });
    fixture = TestBed.createComponent(PrescriptionManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
