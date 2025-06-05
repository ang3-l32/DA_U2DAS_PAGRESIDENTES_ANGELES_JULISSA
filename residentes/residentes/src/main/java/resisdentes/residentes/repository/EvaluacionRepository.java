package resisdentes.residentes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import resisdentes.residentes.model.Evaluacion;

public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {
    // Aquí puedes agregar consultas personalizadas si quieres
}
