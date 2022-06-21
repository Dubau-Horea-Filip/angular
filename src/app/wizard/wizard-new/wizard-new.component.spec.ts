import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WizardNewComponent } from './wizard-new.component';

describe('WizardNewComponent', () => {
  let component: WizardNewComponent;
  let fixture: ComponentFixture<WizardNewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WizardNewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WizardNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
