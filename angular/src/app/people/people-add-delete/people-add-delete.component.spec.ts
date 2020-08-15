import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PeopleAddDeleteComponent } from './people-add-delete.component';

describe('PeopleAddDeleteComponent', () => {
  let component: PeopleAddDeleteComponent;
  let fixture: ComponentFixture<PeopleAddDeleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PeopleAddDeleteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PeopleAddDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
