package resisdentes.residentes.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import resisdentes.residentes.model.Tutoria;

public interface TutoriaRepository extends JpaRepository<Tutoria, Long> {
    // Aquí puedes agregar consultas personalizadas si quieres
}
