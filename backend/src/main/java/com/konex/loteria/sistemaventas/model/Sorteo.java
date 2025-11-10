package com.konex.loteria.sistemaventas.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "sorteos")
public class Sorteo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre_sorteo", nullable = false)
    @JsonProperty("nombreSorteo") // permite mapear JSON de Angular
    private String nombre;

    @Column(name = "fecha_sorteo", nullable = false)
    @JsonProperty("fechaSorteo")
    @JsonFormat(pattern = "yyyy-MM-dd") // para mapear correctamente el input type="date"
    private LocalDate fecha;

    @JsonManagedReference("sorteo-billetes")
    @OneToMany(mappedBy = "sorteo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Billete> billetes;

    public Sorteo() {}

    public Sorteo(String nombre, LocalDate fecha, List<Billete> billetes) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.billetes = billetes;
    }

    // Getters y Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public List<Billete> getBilletes() { return billetes; }
    public void setBilletes(List<Billete> billetes) { this.billetes = billetes; }
}
