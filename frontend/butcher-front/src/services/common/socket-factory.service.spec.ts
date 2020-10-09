import { TestBed } from '@angular/core/testing';

import { SocketFactoryService } from './socket-factory.service';

describe('SocketFactoryService', () => {
  let service: SocketFactoryService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SocketFactoryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
