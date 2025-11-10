package com.konex.loteria.sistemaventas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.persistence.EntityNotFoundException;
import com.konex.loteria.sistemaventas.dto.VentaPeticionDTO;
import com.konex.loteria.sistemaventas.model.Billete;
import com.konex.loteria.sistemaventas.service.VentaService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    private final VentaService ventaService;

    
    public VentaController(VentaService ventaService){
        this.ventaService = ventaService;
    }

    /**
     * 
     * endpoint para vernder un billete a un cliente
     */

    @PostMapping
public ResponseEntity<?> venderBillete(@Valid @RequestBody VentaPeticionDTO ventaDTO){
    try {
        Billete billeteVendido = ventaService.venderBillete(ventaDTO);
        return ResponseEntity.ok(billeteVendido);
    } catch (EntityNotFoundException | IllegalStateException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(e.getMessage());
    }
}

}
