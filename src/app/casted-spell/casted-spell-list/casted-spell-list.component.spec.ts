import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CastedSpellListComponent } from './casted-spell-list.component';

describe('CastedSpellListComponent', () => {
  let component: CastedSpellListComponent;
  let fixture: ComponentFixture<CastedSpellListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CastedSpellListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CastedSpellListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
