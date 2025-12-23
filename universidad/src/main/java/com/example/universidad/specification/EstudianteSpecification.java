package com.example.universidad.specification;
import com.example.universidad.model.Estudiante;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

public class EstudianteSpecification {

    public static Specification<Estudiante> buscar(
            String nombre,
            String apellido,
            String codigoCarrera,
            String codigoFacultad
    ) {
        return (root, query, cb) -> {
            Join<Object, Object> carreraJoin = root.join("carrera", JoinType.INNER);
            Join<Object, Object> facultadJoin = carreraJoin.join("facultad", JoinType.INNER);

            var predicates = cb.conjunction();

            if (nombre != null && !nombre.isEmpty()) {
                predicates = cb.and(predicates,
                        cb.like(cb.lower(root.get("nombres")), "%" + nombre.trim().toLowerCase() + "%"));
            }

            if (apellido != null && !apellido.isEmpty()) {
                predicates = cb.and(predicates,
                        cb.like(cb.lower(root.get("apellidos")), "%" + apellido.trim().toLowerCase() + "%"));
            }

            if (codigoCarrera != null && !codigoCarrera.isEmpty()) {
                predicates = cb.and(predicates,
                        //cb.equal(cb.lower(carreraJoin.get("codigo")), codigoCarrera.toLowerCase()));
                        cb.like(cb.lower(carreraJoin.get("codigo")), "%" + codigoCarrera.trim().toLowerCase() + "%"));
            }

            if (codigoFacultad != null && !codigoFacultad.isEmpty()) {
                predicates = cb.and(predicates,
                        //cb.equal(cb.lower(facultadJoin.get("codigo")), codigoFacultad.toLowerCase()));
                        cb.like(cb.lower(facultadJoin.get("codigo")), "%" + codigoFacultad.trim().toLowerCase() + "%"));
            }

            return predicates;
        };
    }
}
