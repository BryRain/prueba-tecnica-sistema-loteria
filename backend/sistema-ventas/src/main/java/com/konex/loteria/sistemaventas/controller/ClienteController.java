package com.konex.loteria.sistemaventas.controller;

import com.konex.loteria.sistemaventas.dto.ClienteCreacionDTO;
import com.konex.loteria.sistemaventas.model.Cliente;
import com.konex.loteria.sistemaventas.service.ClienteService;
import com.konex.loteria.sistemaventas.service.BilleteService;
import com.konex.loteria.sistemaventas.dto.HistorialBilleteDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;
    private final BilleteService billeteService;

    public ClienteController(ClienteService clienteService, BilleteService billeteService) {
        this.clienteService = clienteService;
        this.billeteService = billeteService;
    }

    /**
     * Endopoint para crear un nuevo cliente
     */

    @PostMapping
    public ResponseEntity<Cliente> crearCliente (@RequestBody ClienteCreacionDTO clienteDTO){
        Cliente nuevoCliente = clienteService.crearCliente(clienteDTO);
        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
     }

    /**
    * endpoint para consultar billetes comprados por un cliente
    */

    @GetMapping("/{idCliente}/historial")
    public ResponseEntity<List<HistorialBilleteDTO>> consultarHistorialPorCliente(@PathVariable Long idCliente) {
        List<HistorialBilleteDTO> historial = billeteService.consultarHistorialPorCliente(idCliente);
        return new ResponseEntity<>(historial, HttpStatus.OK); 
    }
}

