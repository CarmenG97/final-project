import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AmateurDetailsComponent } from './amateur-details.component';

describe('AmateurDetailsComponent', () => {
  let component: AmateurDetailsComponent;
  let fixture: ComponentFixture<AmateurDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AmateurDetailsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AmateurDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
