import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Sorteo } from '../models/sorteo.model';
import { Billete } from '../models/billete.model';
import { Cliente } from '../models/cliente.model';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private API_URL = 'http://localhost:8081/api';

  constructor(private http: HttpClient) { }

  /**
   * 
   * listar sorteos
   */
  public getSorteos(): Observable<Sorteo[]> {
    return this.http.get<Sorteo[]>(`${this.API_URL}/sorteos`);
  }
  
  /**
   * 
   * registrar cliente
   */
  public registrarCliente(datos: { nombre: string, correo: string }): Observable<any> {
    return this.http.post(`${this.API_URL}/clientes`, datos);
  }

  /**
   * 
   * vender billete
   */

  public venderBillete(idBillete: number, idCliente: number): Observable<any> {
    const datosVenta = { billeteId: idBillete, clienteId: idCliente };
    return this.http.post(`${this.API_URL}/ventas`, datosVenta);
  }

  /**
   * 
   * ver historial de un cliente 
   */
  public getHistorialCliente(idCliente: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.API_URL}/clientes/${idCliente}/historial`);
  }

  /**
   * 
   * buscar historial por nombre
   *  */ 
  public buscarHistorialPorNombre(nombre: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.API_URL}/clientes/buscar?nombre=${encodeURIComponent(nombre)}`);
  }

  /**
   *
   * listar billetes por sorteo 
   */
  public getBilletesPorSorteo(idSorteo: number): Observable<Billete[]> {
    return this.http.get<Billete[]>(`${this.API_URL}/sorteos/${idSorteo}/billetes`);
  }

  /**
   * 
   *listar clientes 
   */
  public getClientes(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>(`${this.API_URL}/clientes`);
  }
}
