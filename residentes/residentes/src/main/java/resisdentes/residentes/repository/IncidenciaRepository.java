package resisdentes.residentes.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import resisdentes.residentes.model.Incidencia;

public interface IncidenciaRepository extends JpaRepository<Incidencia, Long> {
    // Aquí puedes agregar consultas personalizadas si quieres
}
