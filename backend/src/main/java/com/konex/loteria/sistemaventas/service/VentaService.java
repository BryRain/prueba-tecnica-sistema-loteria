package com.konex.loteria.sistemaventas.service;

import com.konex.loteria.sistemaventas.model.Billete;
import com.konex.loteria.sistemaventas.model.Cliente;
import com.konex.loteria.sistemaventas.dto.VentaPeticionDTO;
import com.konex.loteria.sistemaventas.repository.BilleteRepository;
import com.konex.loteria.sistemaventas.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.konex.loteria.sistemaventas.model.EstadoBillete;

import java.time.LocalDateTime;

@Service
public class VentaService {

    private final BilleteRepository billeteRepository;
    private final ClienteRepository clienteRepository;

    /**
     * 
     * Constructor de VentaService
     * 
     */
    public VentaService(BilleteRepository billeteRepository, ClienteRepository clienteRepository) {
        this.billeteRepository = billeteRepository;
        this.clienteRepository = clienteRepository;
    }

    /** 
     * metodo para veder un billete a un cliente
     * 
     */
    
    @Transactional
    public Billete venderBillete(VentaPeticionDTO ventaDTO) {
    Billete billete = billeteRepository.findById(ventaDTO.getBilleteId())
            .orElseThrow(() -> new EntityNotFoundException("billete no encontrado"));

    Cliente cliente = clienteRepository.findById(ventaDTO.getClienteId())
            .orElseThrow(() -> new EntityNotFoundException("cliente no encontrado"));

    if (!billete.getEstado().equals(EstadoBillete.DISPONIBLE)) {
        throw new IllegalStateException("el billete no est disponible para la venta");
    }

    billete.setCliente(cliente);
    billete.setEstado(EstadoBillete.VENDIDO);
    billete.setFechaVenta(LocalDateTime.now());

    return billeteRepository.save(billete);
}

}
