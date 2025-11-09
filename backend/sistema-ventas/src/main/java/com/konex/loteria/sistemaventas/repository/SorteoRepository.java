package com.konex.loteria.sistemaventas.repository;

import com.konex.loteria.sistemaventas.model.Sorteo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  SorteoRepository  extends JpaRepository<Sorteo, Long> {


}
