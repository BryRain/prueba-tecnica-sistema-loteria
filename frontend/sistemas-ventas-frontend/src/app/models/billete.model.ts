export interface Billete {
  id: number;
  numero: string;
  precio: number;
  estado: 'disponible' | 'vendido';
}