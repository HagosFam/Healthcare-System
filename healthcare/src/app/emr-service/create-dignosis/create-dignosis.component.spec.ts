import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateDignosisComponent } from './create-dignosis.component';

describe('CreateDignosisComponent', () => {
  let component: CreateDignosisComponent;
  let fixture: ComponentFixture<CreateDignosisComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreateDignosisComponent]
    });
    fixture = TestBed.createComponent(CreateDignosisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
