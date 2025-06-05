package resisdentes.residentes.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import resisdentes.residentes.model.RegistroUsuario;

public interface RegistroUsuarioRepository extends JpaRepository<RegistroUsuario, Long> {

    RegistroUsuario findByCorreo(String correoOUsuario);
    // Aquí puedes agregar consultas personalizadas si quieres
}
