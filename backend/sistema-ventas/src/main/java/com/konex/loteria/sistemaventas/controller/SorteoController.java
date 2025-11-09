package com.konex.loteria.sistemaventas.controller;

import com.konex.loteria.sistemaventas.dto.SorteoCreacioDTO;
import com.konex.loteria.sistemaventas.model.Sorteo;
import com.konex.loteria.sistemaventas.service.SorteoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
public ResponseEntity<Sorteo> crearSorteo(@RequestBody SorteoCreacioDTO sorteoDTO){
    Sorteo nuevoSorteo = sorteoService.crearSorteo(sorteoDTO);
    return new ResponseEntity<>(nuevoSorteo, HttpStatus.CREATED);
}

/**
 * 
 * endpoint para listar todos los sorteos
 */

@GetMapping
public ResponseEntity<List<Sorteo>> listarSorteos(){
    List<Sorteo> sorteos = sorteoService.listarSorteos();
    return new ResponseEntity<>(sorteos, HttpStatus.OK);
}

}
