package resisdentes.residentes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import resisdentes.residentes.model.LoginRequest;
import resisdentes.residentes.model.RegistroUsuario;
import resisdentes.residentes.repository.RegistroUsuarioRepository;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private RegistroUsuarioRepository repository;

    // Endpoint para iniciar sesión (login)
    @PostMapping
    public ResponseEntity<?> iniciarSesion(@RequestBody LoginRequest login) {
        RegistroUsuario usuario = repository.findByCorreo(login.getCorreoOUsuario());

        if (usuario != null && usuario.getContrasena().equals(login.getContrasena())) {
            // Retorna el ID del usuario para guardarlo en localStorage (como token básico)
            return ResponseEntity.ok(usuario.getId());
        } else {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }

    // Listar todos los usuarios registrados (GET)
    @GetMapping("/usuarios")
    public List<RegistroUsuario> obtenerUsuarios() {
        return repository.findAll();
    }

    // Actualizar usuario (PUT)
    @PutMapping("/usuarios/{id}")
    public ResponseEntity<RegistroUsuario> actualizarUsuario(@PathVariable Long id, @RequestBody RegistroUsuario usuarioDetalles) {
        return repository.findById(id).map(usuario -> {
            usuario.setNombreCompleto(usuarioDetalles.getNombreCompleto());
            usuario.setCorreo(usuarioDetalles.getCorreo());
            usuario.setContrasena(usuarioDetalles.getContrasena());
            usuario.setTelefono(usuarioDetalles.getTelefono());
            usuario.setCarrera(usuarioDetalles.getCarrera());
            usuario.setSemestre(usuarioDetalles.getSemestre());
            usuario.setFotoPerfil(usuarioDetalles.getFotoPerfil());
            RegistroUsuario actualizado = repository.save(usuario);
            return ResponseEntity.ok(actualizado);
        }).orElse(ResponseEntity.notFound().build());
    }

    // Nuevo endpoint para eliminar usuario (DELETE)
    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Long id) {
        return repository.findById(id).map(usuario -> {
            repository.deleteById(id);
            return ResponseEntity.ok("Usuario eliminado correctamente");
        }).orElse(ResponseEntity.status(404).body("Usuario no encontrado"));
    }
}
