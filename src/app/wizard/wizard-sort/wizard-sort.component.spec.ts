import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WizardSortComponent } from './wizard-sort.component';

describe('WizardSortComponent', () => {
  let component: WizardSortComponent;
  let fixture: ComponentFixture<WizardSortComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WizardSortComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WizardSortComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
