/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.escuela.controller;

import com.example.escuela.model.Escuela;
import com.example.escuela.service.EscuelaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Micaela
 */
@RestController
@RequestMapping("/escuela")
public class EscuelaIndexController {

    @Autowired
    private EscuelaService escuelaService;

    @GetMapping("/all")
    public List<Escuela> getEscuelas() {
        return escuelaService.readAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Escuela> getEscuela(@PathVariable int id) {
        Escuela escuela = escuelaService.read(id);
        return ResponseEntity.ok(escuela);
    }

    @DeleteMapping("/{id}")
    public int deleteEscuela(@PathVariable int id) {        
        return escuelaService.delete(id);
    }
    @PostMapping("/add")
    public int addEscuela(@RequestBody Escuela escuela) {  
        System.out.println(escuela.getNombre());
        return escuelaService.create(escuela);
    }
    @PutMapping("/edit")
    public int editEscuela(@RequestBody Escuela escuela) {  
        Escuela pos = new Escuela(escuela.getIdescuela(),escuela.getNombre());
        System.out.println(escuela.getIdescuela()+" , "+escuela.getNombre());
        return escuelaService.update(escuela);
    }
}
