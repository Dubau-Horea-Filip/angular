import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WizardDetailComponent } from './wizard-detail.component';

describe('WizardDetailComponent', () => {
  let component: WizardDetailComponent;
  let fixture: ComponentFixture<WizardDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WizardDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WizardDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
