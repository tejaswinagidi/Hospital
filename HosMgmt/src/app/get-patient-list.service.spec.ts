import { TestBed } from '@angular/core/testing';

import { GetPatientListService } from './get-patient-list.service';

describe('GetPatientListService', () => {
  let service: GetPatientListService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetPatientListService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
