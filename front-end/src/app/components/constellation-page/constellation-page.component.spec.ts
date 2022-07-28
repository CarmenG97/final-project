import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConstellationPageComponent } from './constellation-page.component';

describe('ConstellationPageComponent', () => {
  let component: ConstellationPageComponent;
  let fixture: ComponentFixture<ConstellationPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConstellationPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConstellationPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
