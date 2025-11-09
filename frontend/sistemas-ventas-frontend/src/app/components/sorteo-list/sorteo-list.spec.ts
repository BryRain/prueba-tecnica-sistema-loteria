import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SorteoList } from './sorteo-list';

describe('SorteoList', () => {
  let component: SorteoList;
  let fixture: ComponentFixture<SorteoList>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SorteoList]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SorteoList);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
