package com.example.universidad.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "estudiante")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Long id;

    @Column(name = "carnet", nullable = false, unique = true, length = 20)
    private String carnet;

    @Column( nullable = false, length = 120)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 120)
    private String apellidos;

    @Column(name = "sexo", nullable = false, length = 1)
    private String sexo;

    private LocalDate fechaNacimiento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_carrera", nullable = false)
    private Carrera carrera;
}
