import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../services/api.service'; // Importa tu servicio
import { Sorteo } from '../../models/sorteo.model'; // Importa tu modelo
import { CommonModule } from '@angular/common'; // <-- ¡IMPORTANTE para *ngIf y *ngFor!
import { RouterModule } from '@angular/router'; // <-- ¡IMPORTANTE para routerLink!

@Component({
  selector: 'app-sorteo-list',
  
  // --- ¡AQUÍ ESTÁN LAS PARTES QUE FALTABAN! ---
  standalone: true, // 1. Tienes que decirle que es un componente independiente
  imports: [
    CommonModule,   // 2. Tienes que importar los módulos que usa el HTML
    RouterModule
  ],
  // ---------------------------------------------

  templateUrl: './sorteo-list.html', // (Esto está bien, coincide con tu archivo)
  styleUrl: './sorteo-list.css',   // (Esto está bien, coincide con tu archivo)
})

// --- 3. CAMBIA EL NOMBRE DE LA CLASE ---
// (Para que coincida con lo que espera el archivo de rutas)
export class SorteoListComponent implements OnInit {

  // Una variable para guardar la lista de sorteos
  public sorteos: Sorteo[] = [];
  public cargando = true; // Para mostrar un mensaje de "Cargando..."

  // Inyecta el servicio en el constructor
  constructor(private apiService: ApiService) { }

  // Este método se ejecuta automáticamente cuando el componente carga
  ngOnInit(): void {
    this.cargarSorteos();
  }

  cargarSorteos(): void {
    this.cargando = true;
    this.apiService.getSorteos().subscribe(
      (data) => {
        this.sorteos = data; 
        this.cargando = false;
        console.log('Sorteos cargados:', data);
      },
      (error) => {
        console.error('Error al cargar sorteos:', error);
        this.cargando = false;
      }
    );
  }
}