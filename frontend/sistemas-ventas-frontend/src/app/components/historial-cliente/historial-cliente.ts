import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-historial-cliente',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './historial-cliente.html',
  styleUrls: ['./historial-cliente.css']
})
export class HistorialClienteComponent {

  public nombreClienteABuscar: string = ''; 
  public historial: any[] = [];
  public cargando = false;
  public mensaje = '';

  constructor(private apiService: ApiService) {}

  public buscarHistorial(): void {
    if (!this.nombreClienteABuscar.trim()) {
      this.mensaje = 'Por favor, introduce un nombre de cliente.';
      this.historial = [];
      return;
    }

    this.cargando = true;
    this.historial = [];
    this.mensaje = '';

    this.apiService.buscarHistorialPorNombre(this.nombreClienteABuscar).subscribe(
      (data) => {
        this.historial = data;
        if (data.length === 0) {
          this.mensaje = 'No se encontraron billetes vendidos para este cliente.';
        }
        this.cargando = false;
      },
      (error) => {
        this.mensaje = 'Error al cargar el historial.';
        this.cargando = false;
        console.error(error);
      }
    );
  }
}
