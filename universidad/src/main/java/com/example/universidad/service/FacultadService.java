package com.example.universidad.service;

import com.example.universidad.model.Facultad;
import com.example.universidad.repository.FacultadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultadService {

    private final FacultadRepository repo;

    public FacultadService(FacultadRepository repo) {
        this.repo = repo;
    }

    public List<Facultad> listar(){
        return repo.findAll();
    }

    public Facultad guardar(Facultad facultad){
        return repo.save(facultad);
    }

    public Facultad buscarPorId(Long id){
        return repo.findById(id).orElse(null);
    }

    public void eliminar(Long id){
        repo.deleteById(id);
    }
}
