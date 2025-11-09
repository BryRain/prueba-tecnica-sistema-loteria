package com.konex.loteria.sistemaventas.repository;

import com.konex.loteria.sistemaventas.model.Billete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface  BilleteRepository extends JpaRepository<Billete, Long>{

List<Billete> findByClienteId(Long clienteId);

}
