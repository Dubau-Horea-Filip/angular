import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CastedSpellDetailComponent } from './casted-spell-detail.component';

describe('CastedSpellDetailComponent', () => {
  let component: CastedSpellDetailComponent;
  let fixture: ComponentFixture<CastedSpellDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CastedSpellDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CastedSpellDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
