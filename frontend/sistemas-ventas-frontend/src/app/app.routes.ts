import { Routes } from '@angular/router';

// --- 1. IMPORTA TUS COMPONENTES ---
import { SorteoListComponent } from './components/sorteo-list/sorteo-list';
import { ClienteRegistroComponent } from './components/cliente-registro/cliente-registro';
import { HistorialClienteComponent } from './components/historial-cliente/historial-cliente';

// --- ¡CORRECCIÓN EN LA RUTA DEL ARCHIVO! ---
// Debe coincidir con la convención de carpetas: minúsculas y guiones.
import { SorteoDetalleComponent } from './components/sorteo-detalle/sorteo-detalle'; 

export const routes: Routes = [
    
  { path: 'sorteos', component: SorteoListComponent },

  // Esta es la ruta dinámica para la "vista del sorteo" (Req. F-3)
  { path: 'sorteos/:id', component: SorteoDetalleComponent },

  { path: 'registrar-cliente', component: ClienteRegistroComponent },
  { path: 'historial', component: HistorialClienteComponent },

  { path: '', redirectTo: '/sorteos', pathMatch: 'full' }
];