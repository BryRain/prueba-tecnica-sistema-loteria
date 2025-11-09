import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Sorteo } from '../models/sorteo.model';
import { Billete } from '../models/billete.model';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  // La URL de tu backend
  private API_URL = 'http://localhost:8081/api';

  constructor(private http: HttpClient) { }

  // --- REQUISITO: Listar Sorteos ---
  public getSorteos(): Observable<Sorteo[]> {
    return this.http.get<Sorteo[]>(`${this.API_URL}/sorteos`);
  }

  // --- REQUISITO: Registrar Clientes ---
  // (Usamos 'any' para la respuesta, pero podrías usar Cliente)
  public registrarCliente(datos: { nombre: string, correo: string }): Observable<any> {
    return this.http.post(`${this.API_URL}/clientes`, datos);
  }

  // --- REQUISITO: Vender Billetes ---
  public venderBillete(idBillete: number, idCliente: number): Observable<any> {
    const datosVenta = { idBillete: idBillete, idCliente: idCliente };
    return this.http.post(`${this.API_URL}/ventas`, datosVenta);
  }

  // --- REQUISITO: Consultar Historial ---
  public getHistorialCliente(idCliente: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.API_URL}/clientes/${idCliente}/historial`);
  }

  // --- (BONUS) Para ver billetes de un sorteo ---
  // (NOTA: Asegúrate de tener este endpoint en tu Backend)
  public getBilletesPorSorteo(idSorteo: number): Observable<Billete[]> {
     // Asumo que el endpoint es /api/sorteos/{id}/billetes
    return this.http.get<Billete[]>(`${this.API_URL}/sorteos/${idSorteo}/billetes`);
  }
}