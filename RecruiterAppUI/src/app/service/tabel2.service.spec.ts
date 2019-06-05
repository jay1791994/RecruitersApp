import { TestBed } from '@angular/core/testing';

import { Tabel2Service } from './tabel2.service';

describe('Tabel2Service', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: Tabel2Service = TestBed.get(Tabel2Service);
    expect(service).toBeTruthy();
  });
});
