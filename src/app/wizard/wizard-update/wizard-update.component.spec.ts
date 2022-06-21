import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WizardUpdateComponent } from './wizard-update.component';

describe('WizardUpdateComponent', () => {
  let component: WizardUpdateComponent;
  let fixture: ComponentFixture<WizardUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WizardUpdateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WizardUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
