import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatePatientComponent } from './create-patient.component';

describe('CreatePatientComponent', () => {
  let component: CreatePatientComponent;
  let fixture: ComponentFixture<CreatePatientComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreatePatientComponent]
    });
    fixture = TestBed.createComponent(CreatePatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
