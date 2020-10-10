import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VoteResultBarComponent } from './vote-result-bar.component';

describe('VoteResultBarComponent', () => {
  let component: VoteResultBarComponent;
  let fixture: ComponentFixture<VoteResultBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VoteResultBarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VoteResultBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
