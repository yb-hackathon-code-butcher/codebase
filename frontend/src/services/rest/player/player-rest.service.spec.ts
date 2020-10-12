import { TestBed } from '@angular/core/testing';

import { PlayerRestService } from './player-rest.service';

describe('PlayerRestService', () => {
  let service: PlayerRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PlayerRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
