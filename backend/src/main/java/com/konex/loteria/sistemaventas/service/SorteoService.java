package com.konex.loteria.sistemaventas.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.konex.loteria.sistemaventas.dto.SorteoCreacioDTO;
import com.konex.loteria.sistemaventas.dto.SorteoRespuestaDTO;
import com.konex.loteria.sistemaventas.model.Sorteo;
import com.konex.loteria.sistemaventas.repository.SorteoRepository;

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
    public List<SorteoRespuestaDTO> listarSorteos() {
        List<Sorteo> sorteos = sorteoRepository.findAll();

        return sorteos.stream()
                .map(this::convertirASorteoDTO)
                .collect(Collectors.toList());
}


    /**
     * 
     * metodo auxiliar para convertir una entidad sorteo a su DTO correspondiente
     */
    private SorteoRespuestaDTO convertirASorteoDTO(Sorteo sorteo) {
        SorteoRespuestaDTO dto = new SorteoRespuestaDTO();
        dto.setId(sorteo.getId());
        dto.setNombre(sorteo.getNombre());
        dto.setFecha(sorteo.getFecha());
        return dto;
    }


}
