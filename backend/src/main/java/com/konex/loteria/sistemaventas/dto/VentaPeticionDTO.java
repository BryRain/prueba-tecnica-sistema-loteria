package com.konex.loteria.sistemaventas.dto;

import lombok.Data;

@Data
public class VentaPeticionDTO {

    private long clienteId;
    private long billeteId;

    public VentaPeticionDTO(){

    }

    public VentaPeticionDTO(long clienteId, long billeteId){
        this.clienteId = clienteId;
        this.billeteId = billeteId;
    }
}
