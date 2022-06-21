import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpellUpdateComponent } from './spell-update.component';

describe('SpellUpdateComponent', () => {
  let component: SpellUpdateComponent;
  let fixture: ComponentFixture<SpellUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SpellUpdateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SpellUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
