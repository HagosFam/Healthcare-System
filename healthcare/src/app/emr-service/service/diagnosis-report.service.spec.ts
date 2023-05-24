import { TestBed } from '@angular/core/testing';

import { DiagnosisReportService } from './diagnosis-report.service';

describe('DiagnosisReportService', () => {
  let service: DiagnosisReportService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DiagnosisReportService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
