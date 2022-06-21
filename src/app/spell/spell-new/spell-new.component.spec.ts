import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpellNewComponent } from './spell-new.component';

describe('SpellNewComponent', () => {
  let component: SpellNewComponent;
  let fixture: ComponentFixture<SpellNewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SpellNewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SpellNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
