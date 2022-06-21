import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CastedSpellNewComponent } from './casted-spell-new.component';

describe('CastedSpellNewComponent', () => {
  let component: CastedSpellNewComponent;
  let fixture: ComponentFixture<CastedSpellNewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CastedSpellNewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CastedSpellNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
