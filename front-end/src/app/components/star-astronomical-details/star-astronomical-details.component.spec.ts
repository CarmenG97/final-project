import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StarAstronomicalDetailsComponent } from './star-astronomical-details.component';

describe('StarAstronomicalDetailsComponent', () => {
  let component: StarAstronomicalDetailsComponent;
  let fixture: ComponentFixture<StarAstronomicalDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StarAstronomicalDetailsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StarAstronomicalDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
