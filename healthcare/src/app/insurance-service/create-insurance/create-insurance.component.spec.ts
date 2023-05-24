import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateInsuranceComponent } from './create-insurance.component';

describe('CreateInsuranceComponent', () => {
  let component: CreateInsuranceComponent;
  let fixture: ComponentFixture<CreateInsuranceComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreateInsuranceComponent]
    });
    fixture = TestBed.createComponent(CreateInsuranceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
