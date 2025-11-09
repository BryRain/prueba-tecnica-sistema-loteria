package com.konex.loteria.sistemaventas.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * entidad que representa un sorteo de loteria ene el sistema
 * 
 * La relacion entre sorteo y billete es de uno a muchos
 */

@Entity
@Table(name = "sorteos")
public class Sorteo{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id; 

@Column(name = "nombre_sorteo", nullable = false)
private String nombre;

@Column(name = "fecha_sorteo", nullable = false)
private LocalDate fecha;

@OneToMany(mappedBy = "sorteo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
@JsonIgnore
private List<Billete> billetes;

public Sorteo(){

}

public Sorteo(String nombre, LocalDate fecha, List<Billete> billetes) {
    this.nombre = nombre;
    this.fecha = fecha;
    this.billetes = billetes;
}

public long getId(){
    return id;
}

public void setId(long id){
    this.id = id;

}
public String getNombre(){
    return nombre;

}
public void setNombre(String nombre){
    this.nombre = nombre;

}

public LocalDate getFecha(){
    return fecha;

}
public void setFecha(LocalDate fecha){
    this.fecha = fecha;

} 

public List<Billete> getBilletes(){
    return billetes;
}
public void setBilletes(List<Billete> billetes){
    this.billetes = billetes;
}
}

