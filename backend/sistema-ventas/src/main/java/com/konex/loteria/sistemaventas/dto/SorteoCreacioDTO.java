package com.konex.loteria.sistemaventas.dto;

import lombok.Data;

@Data
public class SorteoCreacioDTO {

    private String nombre;
    private String fecha;

    public SorteoCreacioDTO(){

    }

    public SorteoCreacioDTO(String nombre, String fecha){
        this.nombre = nombre;
        this.fecha = fecha;
    }

}
