package resisdentes.residentes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import resisdentes.residentes.model.RegistroUsuario;
import resisdentes.residentes.repository.RegistroUsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class RegistroUsuarioController {
    @Autowired
    private RegistroUsuarioRepository repository;

    @GetMapping
    public List<RegistroUsuario> obtenerTodos() {
        return repository.findAll();
    }

    @PostMapping
    public RegistroUsuario registrar(@RequestBody RegistroUsuario usuario) {
        return repository.save(usuario);
    }

    @PutMapping("/{id}")
    public RegistroUsuario actualizar(@PathVariable Long id, @RequestBody RegistroUsuario usuario) {
        usuario.setId(id);
        return repository.save(usuario);
    }
@DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

