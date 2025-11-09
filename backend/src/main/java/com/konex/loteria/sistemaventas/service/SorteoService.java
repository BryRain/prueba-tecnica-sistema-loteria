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

        if (sorteoDTO.getNombre() == null || sorteoDTO.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre del sorteo no puede estar vacío.");
        }
        if (sorteoDTO.getFecha() == null || sorteoDTO.getFecha().isBlank()) {
            throw new IllegalArgumentException("La fecha del sorteo no puede estar vacía.");
        }

        if (sorteoRepository.existsByNombre(sorteoDTO.getNombre())) {
            throw new IllegalArgumentException("Ya existe un sorteo con el nombre: " + sorteoDTO.getNombre());
        }

        LocalDate fechaParseada;
        try {
            fechaParseada = LocalDate.parse(sorteoDTO.getFecha());
        } catch (Exception e) {
            throw new IllegalArgumentException("El formato de la fecha debe ser YYYY-MM-DD.");
        }

        if (fechaParseada.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha del sorteo no puede ser en el pasado.");
        }

        Sorteo sorteo = new Sorteo();
        sorteo.setNombre(sorteoDTO.getNombre());
        sorteo.setFecha(fechaParseada);
        
        return sorteoRepository.save(sorteo);
    }
    /**
     * 
     * metodo para listar todos los sorteos en el sistema
     */
    public List<Sorteo> listarSorteos(){
        return sorteoRepository.findAll();
    }

}
