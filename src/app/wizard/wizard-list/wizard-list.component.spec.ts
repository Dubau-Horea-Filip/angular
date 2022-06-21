import { ComponentFixture, TestBed } from '@angular/core/testing';
import { WizardListComponent } from './wizard-list.component';

describe('WizardListComponent', () => {
  let component: WizardListComponent;
  let fixture: ComponentFixture<WizardListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WizardListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WizardListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
