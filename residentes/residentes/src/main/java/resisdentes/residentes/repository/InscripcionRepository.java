package resisdentes.residentes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import resisdentes.residentes.model.Inscripcion;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
}
