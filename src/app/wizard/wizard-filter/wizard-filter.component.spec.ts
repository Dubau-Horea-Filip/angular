import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WizardFilterComponent } from './wizard-filter.component';

describe('WizardFilterComponent', () => {
  let component: WizardFilterComponent;
  let fixture: ComponentFixture<WizardFilterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WizardFilterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WizardFilterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
