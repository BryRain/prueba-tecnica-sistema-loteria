import { Component } from '@angular/core';
import { CommonModule } from '@angular/common'; // Para *ngIf, *ngFor, DatePipe, CurrencyPipe
import { FormsModule } from '@angular/forms'; // Para [(ngModel)]
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-historial-cliente',
  standalone: true,
  imports: [
    CommonModule, // <-- Importa CommonModule
    FormsModule   // <-- Importa FormsModule
  ],
  templateUrl: './historial-cliente.html',
  styleUrl: './historial-cliente.css'
})
// 1. Cambiamos el nombre de la clase
export class HistorialClienteComponent {

  // 2. Variables para el formulario y los resultados
  public idClienteABuscar: number | null = null;
  public historial: any[] = [];
  public cargando = false;
  public mensaje = ''; // Para "No se encontraron resultados"

  // 3. Inyectamos el servicio
  constructor(private apiService: ApiService) { }

  // 4. Método para buscar
  public buscarHistorial(): void {
    if (!this.idClienteABuscar) {
      this.mensaje = 'Por favor, introduce un ID de cliente.';
      this.historial = [];
      return;
    }

    this.cargando = true;
    this.historial = [];
    this.mensaje = '';

    this.apiService.getHistorialCliente(this.idClienteABuscar).subscribe(
      (data) => {
        if (data.length === 0) {
          this.mensaje = 'No se encontraron billetes vendidos para este cliente.';
        }
        this.historial = data;
        this.cargando = false;
        console.log('Historial cargado:', data);
      },
      (error) => {
        this.mensaje = 'Error al cargar el historial.';
        this.cargando = false;
        console.error(error);
      }
    );
  }
}