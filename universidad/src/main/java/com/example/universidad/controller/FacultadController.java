package com.example.universidad.controller;

import com.example.universidad.model.Facultad;
import com.example.universidad.service.FacultadService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facultades")
@CrossOrigin
public class FacultadController {
    private final FacultadService service;

    public FacultadController(FacultadService service) {
        this.service = service;
    }

    @GetMapping
    public List<Facultad> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Facultad obtener(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Facultad guardar(@RequestBody Facultad facultad) {
        return service.guardar(facultad);
    }

    @PutMapping("/{id}")
    public Facultad actualizar(@PathVariable Long id, @RequestBody Facultad facultad) {
        facultad.setId(id);
        return service.guardar(facultad);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

}
