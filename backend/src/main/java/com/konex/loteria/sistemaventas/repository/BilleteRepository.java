package com.konex.loteria.sistemaventas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.konex.loteria.sistemaventas.model.Billete;


@Repository
public interface  BilleteRepository extends JpaRepository<Billete, Long>{

List<Billete> findByClienteId(Long clienteId);

List<Billete> findBySorteoId(Long sorteoId);

}
