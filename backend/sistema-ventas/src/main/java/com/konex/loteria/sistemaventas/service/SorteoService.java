package com.konex.loteria.sistemaventas.service;

import org.springframework.stereotype.Service;
import com.konex.loteria.sistemaventas.repository.SorteoRepository;
import com.konex.loteria.sistemaventas.model.Sorteo;
import com.konex.loteria.sistemaventas.dto.SorteoCreacioDTO;
import java.util.List;
import java.time.LocalDate;

@Service
public class SorteoService {

    private final SorteoRepository sorteoRepository;

    public SorteoService(SorteoRepository sorteoRepository){
        this.sorteoRepository = sorteoRepository;
    }

    /**
     * metodo para crear un sorteo en el sistema
     */

     public Sorteo crearSorteo(SorteoCreacioDTO sorteoDTO){
        Sorteo sorteo = new Sorteo();
        sorteo.setNombre(sorteoDTO.getNombre());
        LocalDate fechaParseada = LocalDate.parse(sorteoDTO.getFecha());
        sorteo.setFecha(fechaParseada);

        return sorteoRepository.save(sorteo);
    }

    public List<Sorteo> listarSorteos(){
        return sorteoRepository.findAll();
    }

}
