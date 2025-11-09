package com.konex.loteria.sistemaventas.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;


@Data
public class HistorialBilleteDTO {

    private String numeroBillete;
    private BigDecimal precio;
    private LocalDateTime fechaVenta;
    private String nombreSorteo;

public HistorialBilleteDTO(){

    }

public HistorialBilleteDTO(String numeroBillete, BigDecimal precio, LocalDateTime fechaVenta, String nombreSorteo){
    this.numeroBillete = numeroBillete;
    this.precio = precio;
    this.fechaVenta = fechaVenta;
    this.nombreSorteo = nombreSorteo;

    }

}



