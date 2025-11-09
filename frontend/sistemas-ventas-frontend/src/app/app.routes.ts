import { Routes } from '@angular/router';

// --- 1. IMPORTA TUS COMPONENTES ---
import { SorteoListComponent } from './components/sorteo-list/sorteo-list';
import { ClienteRegistroComponent } from './components/cliente-registro/cliente-registro';
import { HistorialClienteComponent } from './components/historial-cliente/historial-cliente';

export const routes: Routes = [
  // --- 2. DEFINE LAS RUTAS ---
  { path: 'sorteos', component: SorteoListComponent },
  { path: 'registrar-cliente', component: ClienteRegistroComponent },
  { path: 'historial', component: HistorialClienteComponent },

  // --- 3. RUTA POR DEFECTO ---
  { path: '', redirectTo: '/sorteos', pathMatch: 'full' }
];