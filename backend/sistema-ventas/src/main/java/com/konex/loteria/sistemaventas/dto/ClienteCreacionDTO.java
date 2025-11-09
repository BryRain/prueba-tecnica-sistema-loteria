package com.konex.loteria.sistemaventas.dto;

public class ClienteCreacionDTO {

    private String nombre;
    private String correo;


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public ClienteCreacionDTO(){

    }

    public ClienteCreacionDTO(String nombre, String correo){
        this.nombre = nombre;
        this.correo = correo;
    }

}


