import { Routes } from '@angular/router';

import { SorteoListComponent } from './components/sorteo-list/sorteo-list';
import { ClienteRegistroComponent } from './components/cliente-registro/cliente-registro';
import { HistorialClienteComponent } from './components/historial-cliente/historial-cliente';

import { SorteoDetalleComponent } from './components/sorteo-detalle/sorteo-detalle'; 
import { SorteoCrearComponent } from './components/sorteo-crear/sorteo-crear.component';

/**
 * Definición de las rutas de la aplicación.
 */
export const routes: Routes = [
  
  
  { path: 'sorteos', component: SorteoListComponent },

  { path: 'sorteos/:id', component: SorteoDetalleComponent },

  { path: 'registrar-cliente', component: ClienteRegistroComponent },
  { path: 'historial', component: HistorialClienteComponent },
  {path: 'registrar-sorteo', component: SorteoCrearComponent},
  { path: '', redirectTo: '/sorteos', pathMatch: 'full' },
];