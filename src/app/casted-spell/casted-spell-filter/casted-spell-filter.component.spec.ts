import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CastedSpellFilterComponent } from './casted-spell-filter.component';

describe('CastedSpellFilterComponent', () => {
  let component: CastedSpellFilterComponent;
  let fixture: ComponentFixture<CastedSpellFilterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CastedSpellFilterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CastedSpellFilterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
