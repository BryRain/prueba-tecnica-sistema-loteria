package com.konex.loteria.sistemaventas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.konex.loteria.sistemaventas.dto.ClienteCreacionDTO;
import com.konex.loteria.sistemaventas.dto.ClienteRespuestaDTO;
import com.konex.loteria.sistemaventas.dto.HistorialBilleteDTO;
import com.konex.loteria.sistemaventas.model.Cliente;
import com.konex.loteria.sistemaventas.repository.ClienteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /**
     * Crea un nuevo cliente en el sistema y devuelve su DTO.
     */
    public ClienteRespuestaDTO crearCliente(ClienteCreacionDTO clienteDTO) {
        validarClienteDTO(clienteDTO);

        if (clienteRepository.existsByCorreo(clienteDTO.getCorreo())) {
            throw new IllegalArgumentException("Ya existe un cliente con el correo proporcionado");
        }

        Cliente cliente = new Cliente();
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setCorreo(clienteDTO.getCorreo());

        Cliente guardado = clienteRepository.save(cliente);
        return mapToDTO(guardado);
    }

    /**
     * Lista todos los clientes del sistema como DTOs.
     */
    public List<ClienteRespuestaDTO> listarClientes() {
        return clienteRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Busca un cliente por su ID y devuelve su DTO.
     */
    public ClienteRespuestaDTO buscarClientePorId(long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con id: " + id));
        return mapToDTO(cliente);
    }

    /**
     * Busca un cliente por correo y devuelve su DTO.
     */
    public ClienteRespuestaDTO buscarClientePorCorreo(String correo) {
        Cliente cliente = clienteRepository.findByCorreo(correo)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con correo: " + correo));
        return mapToDTO(cliente);
    }

    public List<HistorialBilleteDTO> obtenerHistorialCliente(long id) {
    Cliente cliente = clienteRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con id: " + id));

    return cliente.getBilletes().stream()
            .map(b -> new HistorialBilleteDTO(
                    b.getNumero(),
                    b.getPrecio(),
                    b.getFechaVenta(),
                    b.getSorteo() != null ? b.getSorteo().getNombre() : "N/A" 
            ))
            .collect(Collectors.toList());
}

    /**
     * Valida que los campos obligatorios del DTO no sean nulos.
     */
    private void validarClienteDTO(ClienteCreacionDTO clienteDTO) {
        if (clienteDTO.getNombre() == null || clienteDTO.getCorreo() == null) {
            throw new IllegalArgumentException("El nombre y el correo del cliente no pueden ser nulos");
        }
    }

    /**
     * Mapea un Cliente a ClienteRespuestaDTO.
     */
    private ClienteRespuestaDTO mapToDTO(Cliente cliente) {
        return new ClienteRespuestaDTO(cliente.getId(), cliente.getNombre(), cliente.getCorreo());
    }
}
