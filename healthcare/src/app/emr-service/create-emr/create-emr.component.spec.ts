import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateEmrComponent } from './create-emr.component';

describe('CreateEmrComponent', () => {
  let component: CreateEmrComponent;
  let fixture: ComponentFixture<CreateEmrComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreateEmrComponent]
    });
    fixture = TestBed.createComponent(CreateEmrComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
