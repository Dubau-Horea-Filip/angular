import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WizardDeleteComponent } from './wizard-delete.component';

describe('WizardDeleteComponent', () => {
  let component: WizardDeleteComponent;
  let fixture: ComponentFixture<WizardDeleteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WizardDeleteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WizardDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
