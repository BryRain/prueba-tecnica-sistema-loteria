package com.konex.loteria.sistemaventas.repository;

import com.konex.loteria.sistemaventas.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Long> {

    boolean existsByCorreo(String correo);
    
}
