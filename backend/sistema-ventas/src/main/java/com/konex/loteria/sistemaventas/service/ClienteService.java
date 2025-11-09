package com.konex.loteria.sistemaventas.service;

import com.konex.loteria.sistemaventas.model.Cliente;
import com.konex.loteria.sistemaventas.dto.ClienteCreacionDTO;
import com.konex.loteria.sistemaventas.repository.ClienteRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /**
     * metodo para crear un nnuevo cliente en el sistema
     */

    public Cliente crearCliente(ClienteCreacionDTO clienteDTO){
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setCorreo(clienteDTO.getCorreo());

        if (cliente.getNombre() == null || cliente.getCorreo() == null) {
            throw new IllegalArgumentException("El nombre y el correo del cliente no pueden ser nulos");
        }
        if (clienteRepository.existsByCorreo(cliente.getCorreo())) {
            throw new IllegalArgumentException("Ya existe un cliente con el correo proporcionado");
        }
        return clienteRepository.save(cliente);
    }

    /**
     * 
     * metodo para listar todos los clientes en el sistema
     */
    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    /**
     * 
     * metodo para buscar un cliente por su id
     */
    public Cliente buscarClientePorId(long id){
        return clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con id: "+ id));
    }


    /**
     * 
     * metodo para buscar un cliente por su correo
     */
    public Cliente buscarClientePorCorreo(String correo){
        return clienteRepository.findByCorreo(correo).orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado con correo: " + correo));
    }
}