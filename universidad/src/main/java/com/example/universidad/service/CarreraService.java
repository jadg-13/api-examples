package com.example.universidad.service;

import com.example.universidad.model.Carrera;
import com.example.universidad.repository.CarreraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreraService {

    private final CarreraRepository repo;


    public CarreraService(CarreraRepository repo) {
        this.repo = repo;
    }

    public List<Carrera> listar(){
        return repo.findAll();
    }

    public Carrera guardar(Carrera carrera){
        return repo.save(carrera);
    }

    public Carrera buscarPorId(Long id){
        return repo.findById(id).orElse(null);
    }

    public void eliminar(Long id){
        repo.deleteById(id);
    }
}
