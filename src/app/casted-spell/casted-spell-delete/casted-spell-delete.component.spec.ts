import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CastedSpellDeleteComponent } from './casted-spell-delete.component';

describe('CastedSpellDeleteComponent', () => {
  let component: CastedSpellDeleteComponent;
  let fixture: ComponentFixture<CastedSpellDeleteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CastedSpellDeleteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CastedSpellDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
