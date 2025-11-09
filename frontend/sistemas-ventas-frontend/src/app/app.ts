import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet, RouterLink } from '@angular/router'; // <-- 1. IMPORTA ESTOS DOS

@Component({
  selector: 'app-root',
  standalone: true,

  // --- 2. AÑÁDELOS AQUÍ ---
  // Tu 'imports' probablemente estaba vacío o solo tenía CommonModule
  imports: [
    CommonModule,
    RouterOutlet, // <-- NECESITAS ESTE PARA <router-outlet>
    RouterLink    // <-- Y NECESITAS ESTE PARA los links del menú
  ],
  // -------------------------

  templateUrl: './app.html', // (Esto está bien, apunta a tu html)
  styleUrl: './app.css'
})
export class App {
  title = 'sistemas-ventas-frontend';
}