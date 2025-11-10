package com.konex.loteria.sistemaventas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para devolver información del cliente al frontend.
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRespuestaDTO {

    private Long id;
    private String nombre;
    private String correo;

}
