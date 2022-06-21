import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CastedSpellSortComponent } from './casted-spell-sort.component';

describe('CastedSpellSortComponent', () => {
  let component: CastedSpellSortComponent;
  let fixture: ComponentFixture<CastedSpellSortComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CastedSpellSortComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CastedSpellSortComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
