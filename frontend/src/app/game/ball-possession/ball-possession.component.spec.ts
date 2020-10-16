import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BallPossessionComponent } from './ball-possession.component';

describe('BallPossessionComponent', () => {
  let component: BallPossessionComponent;
  let fixture: ComponentFixture<BallPossessionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BallPossessionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BallPossessionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
