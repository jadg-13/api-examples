package com.example.universidad.controller;

import com.example.universidad.model.Estudiante;
import com.example.universidad.service.EstudianteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
@CrossOrigin
public class EstudianteController {

    public final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Estudiante> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Estudiante obtener(@PathVariable long id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/buscar")
    public List<Estudiante> buscar(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String apellido,
            @RequestParam(required = false) String carrera,
            @RequestParam(required = false) String facultad
    ) {
        return service.buscar(nombre, apellido, carrera, facultad);
    }


    @PostMapping
    public Estudiante guardar(@RequestBody Estudiante estudiante) {
        return service.guardar(estudiante);
    }

    @PutMapping("/{id}")
    public Estudiante actualizar(@PathVariable Long id, @RequestBody Estudiante estudiante) {
        estudiante.setId(id);
        return service.guardar(estudiante);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable long id) {
        service.eliminar(id);
    }

}
