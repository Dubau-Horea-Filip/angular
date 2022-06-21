import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PetNewComponent } from './pet-new.component';

describe('PetNewComponent', () => {
  let component: PetNewComponent;
  let fixture: ComponentFixture<PetNewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PetNewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PetNewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
