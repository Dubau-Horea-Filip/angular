import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpellSortComponent } from './spell-sort.component';

describe('SpellSortComponent', () => {
  let component: SpellSortComponent;
  let fixture: ComponentFixture<SpellSortComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SpellSortComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SpellSortComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
