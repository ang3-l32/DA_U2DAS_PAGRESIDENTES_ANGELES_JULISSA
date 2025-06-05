package resisdentes.residentes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import resisdentes.residentes.model.Actividad;

public interface ActividadRepository extends JpaRepository<Actividad, Long> {
    // Puedes agregar consultas personalizadas aquí
}
