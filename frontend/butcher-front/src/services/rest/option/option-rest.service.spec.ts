import { TestBed } from '@angular/core/testing';

import { OptionRestService } from './option-rest.service';

describe('OptionRestService', () => {
  let service: OptionRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OptionRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
