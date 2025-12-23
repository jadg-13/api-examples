package com.example.universidad.controller;

import com.example.universidad.model.Carrera;
import com.example.universidad.service.CarreraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carreras")
@CrossOrigin
public class CarreraController {
    private final CarreraService service;

    public CarreraController(CarreraService service) {
        this.service = service;
    }

    @GetMapping
    public List<Carrera> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Carrera obtener(@PathVariable long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Carrera guardar(@RequestBody Carrera carrera) {
        return service.guardar(carrera);
    }

    @PutMapping("/{id}")
    public Carrera actualizar(@PathVariable Long id, @RequestBody Carrera carrera) {
        carrera.setId(id);
        return service.guardar(carrera);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable long id) {
        service.eliminar(id);
    }
}
