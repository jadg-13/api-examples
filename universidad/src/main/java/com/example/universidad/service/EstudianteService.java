package com.example.universidad.service;

import com.example.universidad.model.Estudiante;
import com.example.universidad.repository.EstudianteRepository;
import com.example.universidad.specification.EstudianteSpecification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {
    private final EstudianteRepository repo;

    public EstudianteService(EstudianteRepository repo) {
        this.repo = repo;
    }

    public List<Estudiante> listar() {
        return repo.findAll();
    }

    public Estudiante guardar(Estudiante estudiante) {
        return repo.save(estudiante);
    }

    public Estudiante buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Estudiante> buscar(String nombre, String apellido, String carrera, String facultad) {
        return repo.findAll(EstudianteSpecification.buscar(nombre, apellido, carrera, facultad));
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }

}
