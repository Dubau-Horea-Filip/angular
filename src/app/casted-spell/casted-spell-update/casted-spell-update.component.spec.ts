import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CastedSpellUpdateComponent } from './casted-spell-update.component';

describe('CastedSpellUpdateComponent', () => {
  let component: CastedSpellUpdateComponent;
  let fixture: ComponentFixture<CastedSpellUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CastedSpellUpdateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CastedSpellUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
