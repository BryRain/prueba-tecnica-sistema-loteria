import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SorteoDetalleComponent } from './sorteo-detalle';

describe('SorteoDetalle', () => {
  let component: SorteoDetalleComponent;
  let fixture: ComponentFixture<SorteoDetalleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SorteoDetalleComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SorteoDetalleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
