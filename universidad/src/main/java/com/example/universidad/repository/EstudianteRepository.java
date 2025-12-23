package com.example.universidad.repository;

import com.example.universidad.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long>,
        JpaSpecificationExecutor<Estudiante> {
}
