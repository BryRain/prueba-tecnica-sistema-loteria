package com.konex.loteria.sistemaventas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.konex.loteria.sistemaventas.dto.ClienteCreacionDTO;
import com.konex.loteria.sistemaventas.dto.ClienteRespuestaDTO;
import com.konex.loteria.sistemaventas.dto.HistorialBilleteDTO;
import com.konex.loteria.sistemaventas.model.Billete;
import com.konex.loteria.sistemaventas.model.Cliente;
import com.konex.loteria.sistemaventas.service.ClienteService;
import com.konex.loteria.sistemaventas.repository.ClienteRepository;

/**
 * Controlador REST para gestionar los clientes del sistema.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;
    private final ClienteRepository clienteRepository;


    public ClienteController(ClienteService clienteService, ClienteRepository clienteRepository) {
        this.clienteService = clienteService;
        this.clienteRepository = clienteRepository;

    }

    /**
     * Endpoint para obtener el historial de billetes de un cliente por su ID.
     */
    @GetMapping("/{id}/historial")
    public ResponseEntity<List<HistorialBilleteDTO>> obtenerHistorial(@PathVariable long id) {
        List<HistorialBilleteDTO> historial = clienteService.obtenerHistorialCliente(id);
        return ResponseEntity.ok(historial);
    }

    /**
     * Endpoint para buscar historial de billetes por nombre de cliente.
     */
    @GetMapping("/buscar")
    public ResponseEntity<List<HistorialBilleteDTO>> buscarHistorialPorNombre(@RequestParam String nombre) {
        List<Cliente> clientes = clienteRepository.findByNombreContainingIgnoreCase(nombre);

        List<HistorialBilleteDTO> historial = clientes.stream()
            .flatMap(cliente -> cliente.getBilletes().stream()
                .map(billete -> new HistorialBilleteDTO(
                    billete.getNumero(),
                    billete.getPrecio(),
                    billete.getFechaVenta(),
                    billete.getSorteo().getNombre()
                ))
            )
            .toList();

        return ResponseEntity.ok(historial);
    }



    /**
     * Endpoint para crear un nuevo cliente.
     */
    @PostMapping
    public ResponseEntity<ClienteRespuestaDTO> crearCliente(@RequestBody ClienteCreacionDTO clienteDTO) {
        ClienteRespuestaDTO nuevoCliente = clienteService.crearCliente(clienteDTO);
        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }

    /**
     * Endpoint para listar todos los clientes.
     */
    @GetMapping
    public ResponseEntity<List<ClienteRespuestaDTO>> listarClientes() {
        List<ClienteRespuestaDTO> clientes = clienteService.listarClientes();
        return ResponseEntity.ok(clientes);
    }

    /**
     * Endpoint para buscar un cliente por su ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ClienteRespuestaDTO> obtenerClientePorId(@PathVariable long id) {
        ClienteRespuestaDTO cliente = clienteService.buscarClientePorId(id);
        return ResponseEntity.ok(cliente);
    }

    

    /**
     * Endpoint para buscar un cliente por su correo electrónico.
     */
    @GetMapping("/correo")
    public ResponseEntity<ClienteRespuestaDTO> obtenerClientePorCorreo(@RequestParam String correo) {
        ClienteRespuestaDTO cliente = clienteService.buscarClientePorCorreo(correo);
        return ResponseEntity.ok(cliente);
    }
}
