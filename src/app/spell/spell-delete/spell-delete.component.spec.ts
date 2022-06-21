import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpellDeleteComponent } from './spell-delete.component';

describe('SpellDeleteComponent', () => {
  let component: SpellDeleteComponent;
  let fixture: ComponentFixture<SpellDeleteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SpellDeleteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SpellDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
