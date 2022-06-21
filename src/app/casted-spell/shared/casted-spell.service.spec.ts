import { TestBed } from '@angular/core/testing';

import { CastedSpellService } from './casted-spell.service';

describe('CastedSpellService', () => {
  let service: CastedSpellService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CastedSpellService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
