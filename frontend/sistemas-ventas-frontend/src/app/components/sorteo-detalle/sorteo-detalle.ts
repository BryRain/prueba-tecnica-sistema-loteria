import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms'; 
import { ActivatedRoute, Router } from '@angular/router'; 
import { ApiService } from '../../services/api.service';
import { Billete } from '../../models/billete.model';
import { Cliente } from '../../models/cliente.model';

@Component({
  selector: 'app-sorteo-detalle',
  standalone: true,
  imports: [CommonModule, FormsModule], 
  templateUrl: './sorteo-detalle.html',
  styleUrls: ['./sorteo-detalle.css']
})
export class SorteoDetalleComponent implements OnInit {

  public billetes: Billete[] = [];
  public clientes: Cliente[] = [];
  public sorteoId: number = 0;

  public clienteSeleccionadoId: number | null = null;
  public mensaje = '';
  public error = false;

  constructor(
    private route: ActivatedRoute,
    private apiService: ApiService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.sorteoId = +params['id']; 
      if (this.sorteoId) {
        this.cargarBilletes();
        this.cargarClientes();
      }
    });
  }

  cargarBilletes(): void {
    this.apiService.getBilletesPorSorteo(this.sorteoId).subscribe(
      (data) => this.billetes = data,
      (error) => console.error('Error al cargar billetes', error)
    );
  }

  cargarClientes(): void {
    this.apiService.getClientes().subscribe(
      (data) => this.clientes = data,
      (error) => console.error('Error al cargar clientes', error)
    );
  }

  vender(billete: Billete): void {
  this.mensaje = '';
  this.error = false;

  if (!this.clienteSeleccionadoId) {
    this.error = true;
    this.mensaje = 'Por favor, selecciona un cliente para vender el billete.';
    return;
  }

  this.apiService.venderBillete(billete.id, this.clienteSeleccionadoId).subscribe(
    (billeteVendido) => {
      this.error = false;
      this.mensaje = `¡Billete ${billeteVendido.numero} vendido con éxito!`;

      billete.estado = 'vendido';
      billete.cliente = this.clientes.find(c => c.id === this.clienteSeleccionadoId) || undefined;

      this.clienteSeleccionadoId = null;
    },
    (error) => {
      this.error = true;
      this.mensaje = 'Error al vender el billete.';
      console.error(error);
    }
  );
}


}