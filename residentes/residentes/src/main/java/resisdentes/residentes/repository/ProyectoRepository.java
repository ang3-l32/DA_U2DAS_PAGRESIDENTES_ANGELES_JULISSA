package resisdentes.residentes.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import resisdentes.residentes.model.Proyecto;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
    // Aquí puedes agregar consultas personalizadas si quieres
}
