import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicalRecordComponent } from './medical-record.component';

describe('MedicalRecordComponent', () => {
  let component: MedicalRecordComponent;
  let fixture: ComponentFixture<MedicalRecordComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MedicalRecordComponent]
    });
    fixture = TestBed.createComponent(MedicalRecordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
