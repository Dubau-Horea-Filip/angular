import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CastedSpellComponent } from './casted-spell.component';

describe('CastedSpellComponent', () => {
  let component: CastedSpellComponent;
  let fixture: ComponentFixture<CastedSpellComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CastedSpellComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CastedSpellComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
