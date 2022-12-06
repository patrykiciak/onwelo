import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VotersOverviewComponent } from './voters-overview.component';

describe('VotersOverviewComponent', () => {
  let component: VotersOverviewComponent;
  let fixture: ComponentFixture<VotersOverviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VotersOverviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VotersOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
