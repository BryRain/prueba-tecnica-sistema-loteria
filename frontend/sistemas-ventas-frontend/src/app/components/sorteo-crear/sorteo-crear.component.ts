import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-sorteo-crear',
  templateUrl: './sorteo-crear.component.html',
  styleUrls: ['./sorteo-crear.component.css'],
  standalone: true,           
  imports: [CommonModule, FormsModule] 
})
export class SorteoCrearComponent {
  sorteo = { nombre: '', fecha: '' };
  mensaje = '';
  exito = false;

  constructor(private apiService: ApiService) {}

  guardarSorteo(): void {
    if (this.sorteo.nombre && this.sorteo.fecha) {
      this.apiService.crearSorteo(this.sorteo).subscribe({
        next: () => {
          this.mensaje = '✅ Sorteo registrado correctamente.';
          this.exito = true;
          this.sorteo = { nombre: '', fecha: '' };
        },
        error: () => {
          this.mensaje = '❌ Error al registrar el sorteo.';
          this.exito = false;
        }
      });
    } else {
      this.mensaje = 'Se debe llenar todos los campos.';
      this.exito = false;
    }
  }
}
