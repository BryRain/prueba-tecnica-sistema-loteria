import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SorteoCrearComponent } from './sorteo-crear.component';

describe('SorteoCrear', () => {
  let component: SorteoCrearComponent;
  let fixture: ComponentFixture<SorteoCrearComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SorteoCrearComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SorteoCrearComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
