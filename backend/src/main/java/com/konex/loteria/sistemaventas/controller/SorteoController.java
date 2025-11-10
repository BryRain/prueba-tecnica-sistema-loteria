package com.konex.loteria.sistemaventas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.konex.loteria.sistemaventas.dto.SorteoCreacioDTO;
import com.konex.loteria.sistemaventas.dto.SorteoRespuestaDTO;
import com.konex.loteria.sistemaventas.model.Billete;
import com.konex.loteria.sistemaventas.model.Sorteo;
import com.konex.loteria.sistemaventas.service.SorteoService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/sorteos")
public class SorteoController {

    final SorteoService sorteoService;

    public SorteoController(SorteoService sorteoService){
        this.sorteoService = sorteoService;
    }

/**
*
* endpoint para crear un nuevo sorteo 
*/

@PostMapping
public ResponseEntity<Sorteo> crearSorteo(@Valid @RequestBody SorteoCreacioDTO sorteoDTO){
    Sorteo nuevoSorteo = sorteoService.crearSorteo(sorteoDTO);
    return new ResponseEntity<>(nuevoSorteo, HttpStatus.CREATED);
}


/**
 * 
 * Obtener billetes de un sorteo
 * 
 */
    @GetMapping("/{id}/billetes")
    public ResponseEntity<List<Billete>> obtenerBilletesPorSorteo(@PathVariable long id) {
        Sorteo sorteo = sorteoService.buscarSorteoPorId(id);
        List<Billete> billetes = sorteo.getBilletes(); 
        return ResponseEntity.ok(billetes);
    }


/**
 * 
 * endpoint para listar todos los sorteos
 */

@GetMapping
public ResponseEntity<List<SorteoRespuestaDTO>> listarSorteos(){
    List<SorteoRespuestaDTO> sorteos = sorteoService.listarSorteos();
    return new ResponseEntity<>(sorteos, HttpStatus.OK);
}

/**
 * 
 * endpoint para obtener un sorteo por su id
 */
@GetMapping("/{id}")
public ResponseEntity<SorteoRespuestaDTO> obtenerSorteoPorId(Long id){
    SorteoRespuestaDTO sorteo = sorteoService.obtenerSorteoPorId(id);
    return new ResponseEntity<>(sorteo, HttpStatus.OK);

}

}
