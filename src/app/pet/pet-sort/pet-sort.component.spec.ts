import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PetSortComponent } from './pet-sort.component';

describe('PetSortComponent', () => {
  let component: PetSortComponent;
  let fixture: ComponentFixture<PetSortComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PetSortComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PetSortComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
