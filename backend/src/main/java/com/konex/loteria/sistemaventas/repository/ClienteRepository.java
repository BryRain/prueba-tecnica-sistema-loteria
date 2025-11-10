package com.konex.loteria.sistemaventas.repository;

import com.konex.loteria.sistemaventas.model.Cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository  extends JpaRepository<Cliente, Long> {

    boolean existsByCorreo(String correo);

    java.util.Optional<Cliente> findByCorreo(String correo);

    List<Cliente> findByNombreContainingIgnoreCase(String nombre);
    
}
