package com.example.universidad.repository;

import com.example.universidad.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}
