package com.konex.loteria.sistemaventas.controller;

import com.konex.loteria.sistemaventas.service.VentaService;
import com.konex.loteria.sistemaventas.model.Billete;
import com.konex.loteria.sistemaventas.dto.VentaPeticionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
     * endpoint para vernder un billete a un clietne
     */

    @PostMapping
    public ResponseEntity<Billete> venderBillete(@RequestBody VentaPeticionDTO ventaDTO){
     
     try{
        Billete billeteVendido = ventaService.venderBillete(ventaDTO);
        return new ResponseEntity<>(billeteVendido, HttpStatus.OK);
    } catch (RuntimeException e) {
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }}

}
