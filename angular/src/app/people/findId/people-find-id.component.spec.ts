import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PeopleFindIdComponent } from './people-find-id.component';

describe('PeopleFindIdComponent', () => {
  let component: PeopleFindIdComponent;
  let fixture: ComponentFixture<PeopleFindIdComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PeopleFindIdComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PeopleFindIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
