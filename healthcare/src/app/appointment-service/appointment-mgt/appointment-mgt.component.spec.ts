import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppointmentMgtComponent } from './appointment-mgt.component';

describe('AppointmentMgtComponent', () => {
  let component: AppointmentMgtComponent;
  let fixture: ComponentFixture<AppointmentMgtComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AppointmentMgtComponent]
    });
    fixture = TestBed.createComponent(AppointmentMgtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
