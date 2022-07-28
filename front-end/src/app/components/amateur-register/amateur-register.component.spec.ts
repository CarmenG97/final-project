import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AmateurRegisterComponent } from './amateur-register.component';

describe('AmateurRegisterComponent', () => {
  let component: AmateurRegisterComponent;
  let fixture: ComponentFixture<AmateurRegisterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AmateurRegisterComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AmateurRegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
