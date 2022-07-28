import { TestBed } from '@angular/core/testing';

import { StarServiceService } from './star-service.service';

describe('StarServiceService', () => {
  let service: StarServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StarServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
