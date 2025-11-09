package com.konex.loteria.sistemaventas.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * entidad que representa un billete de loteria en el sistema
 * 
 * la realcion entre billete y sorteo es de muchos a uno
 * la relacion entre billetes y clientes es de muchos a uno
 */

@Entity
@Table(name = "billetes")
public class Billete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String numero;

    @Column(nullable=false)
    private BigDecimal precio;

    @Column(nullable=false)
    private EstadoBillete estado;

    @Column(name = "fecha_venta")
    private java.time.LocalDateTime fechaVenta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sorteo_id", nullable = false)
    private Sorteo sorteo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = true)
    private Cliente cliente;

    public Billete(){

    }

    public Billete(String numero, BigDecimal precio, EstadoBillete estado, LocalDateTime fechaVenta, Sorteo sorteo, Cliente cliente){
        this.numero = numero;
        this.precio = precio;
        this.estado = estado;
        this.fechaVenta = fechaVenta;
        this.sorteo = sorteo;
        this.cliente = cliente;
    }
    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }
    public String getNumero(){
        return numero;
    }
    public void setNumero(String numero){
        this.numero = numero;
    }
    public BigDecimal getPrecio(){
        return precio;
    }
    public void setPrecio(BigDecimal precio){
        this.precio = precio;
    }
    public EstadoBillete getEstado(){
        return estado;
    }
    public LocalDateTime getFechaVenta(){
        return fechaVenta;
    }
    public void setFechaVenta(LocalDateTime fechaVenta){
        this.fechaVenta = fechaVenta;
    }

    public void setEstado(EstadoBillete estado){
        this.estado = estado;
    }
    public Sorteo getSorteo(){
        return sorteo;
    }
    public void setSorteo(Sorteo sorteo){
        this.sorteo = sorteo;
    }
    public Cliente getCliente(){
        return cliente;
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

}
