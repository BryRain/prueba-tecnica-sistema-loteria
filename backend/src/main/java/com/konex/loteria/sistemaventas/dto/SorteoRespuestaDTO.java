package com.konex.loteria.sistemaventas.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SorteoRespuestaDTO {

    private long id;
    private String nombre;
    private LocalDate fecha;

    public SorteoRespuestaDTO(){

    }

    public SorteoRespuestaDTO(long id, String nombre, LocalDate fecha){
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
    }

}
