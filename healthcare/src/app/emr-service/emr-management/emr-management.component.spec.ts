import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmrManagementComponent } from './emr-management.component';

describe('EmrManagementComponent', () => {
  let component: EmrManagementComponent;
  let fixture: ComponentFixture<EmrManagementComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EmrManagementComponent]
    });
    fixture = TestBed.createComponent(EmrManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
