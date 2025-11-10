package com.konex.loteria.sistemaventas.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.konex.loteria.sistemaventas.dto.HistorialBilleteDTO;
import com.konex.loteria.sistemaventas.model.Billete;
import com.konex.loteria.sistemaventas.model.EstadoBillete;
import com.konex.loteria.sistemaventas.model.Sorteo;
import com.konex.loteria.sistemaventas.repository.BilleteRepository;
import com.konex.loteria.sistemaventas.repository.SorteoRepository;

/**
 * Servicio para la logica de negocio relacionada con Billetes.
 * incluye la consulta de historial y la creacion de nuevos billetes.
 */
@Service
public class BilleteService {

    private final BilleteRepository billeteRepository;
    private final SorteoRepository sorteoRepository;


    public BilleteService(BilleteRepository billeteRepository, SorteoRepository sorteoRepository) {
        this.billeteRepository = billeteRepository;
        this.sorteoRepository = sorteoRepository;
    }

    /**
     * 
     * consulta el historial de billetes vendidos por un cliente
     */
    
    public List<HistorialBilleteDTO> consultarHistorialPorCliente(Long idCliente) {
        
        List<Billete> billetesVendidos = billeteRepository.findByClienteId(idCliente);

   
        return billetesVendidos.stream()
        .map((Billete b) -> convertirAHistorialDTO(b))
        .collect(Collectors.toList());

    }

    
    public Billete crearBilleteParaSorteo(long idSorteo, String numero, BigDecimal precio) {
    
   
    Sorteo sorteo = sorteoRepository.findById(idSorteo) 
            .orElseThrow(() -> new RuntimeException("Sorteo no encontrado con id: " + idSorteo));

    Billete nuevoBillete = new Billete();
    nuevoBillete.setNumero(numero);
    
    nuevoBillete.setPrecio(precio);
    
    nuevoBillete.setEstado(EstadoBillete.DISPONIBLE); 
    nuevoBillete.setSorteo(sorteo); 

    return billeteRepository.save(nuevoBillete);
}

    /**
    * 
    *obtiene los billetes conectados con el sorteo 
    */

    public List<Billete> obtenerBilletesPorSorteo(long idSorteo) {
        return billeteRepository.findBySorteoId(idSorteo);
    }

    /**
     * metodo auxiliar para convertir una entidad billete a su DTO correspondiente
     */
    
    private HistorialBilleteDTO convertirAHistorialDTO(Billete billete) {
        
        HistorialBilleteDTO dto = new HistorialBilleteDTO();

        dto.setNumeroBillete(billete.getNumero());
        
        dto.setPrecio(billete.getPrecio());
        
        dto.setFechaVenta(billete.getFechaVenta()); 

        if (billete.getSorteo() != null) {
            dto.setNombreSorteo(billete.getSorteo().getNombre());
        } else {
            dto.setNombreSorteo("Sorteo no disponible"); 
        }
        
        return dto;
    }
}
