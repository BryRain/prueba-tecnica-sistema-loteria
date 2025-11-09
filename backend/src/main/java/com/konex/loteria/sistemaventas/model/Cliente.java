package com.konex.loteria.sistemaventas.model;

import java.util.List;

import jakarta.persistence.*;

/**}
 * enidad que representa un cliente en el sistema
 * 
 * la relacion entre cliente y billete es de uno a muchos
 */

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre_cliente", nullable = false)
    private String nombre;

    @Column(name = "correo_cliente", nullable = false, unique = true)
    private String correo;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Billete> billetes;

    public Cliente(){

    }

    public Cliente(String nombre, String correo){
        this.nombre = nombre;
        this.correo = correo;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
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

    public List<Billete> getBilletes() {
        return billetes;
    }

    public void setBilletes(List<Billete> billetes) {
        this.billetes = billetes;
    }

}
