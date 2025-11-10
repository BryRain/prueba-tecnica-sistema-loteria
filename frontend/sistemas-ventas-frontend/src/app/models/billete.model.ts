export interface Cliente {
  id: number;
  nombre: string;
  correo: string;
}

export interface Billete {
  id: number;
  numero: string;
  precio: number;
  estado: 'disponible' | 'vendido';
  cliente?: Cliente; 
}
