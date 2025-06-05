package resisdentes.residentes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import resisdentes.residentes.model.PerfilUsuario;

public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuario, Long> {
}
