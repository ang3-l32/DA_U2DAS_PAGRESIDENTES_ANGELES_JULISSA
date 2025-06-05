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

import resisdentes.residentes.model.PerfilUsuario;
import resisdentes.residentes.repository.PerfilUsuarioRepository;

@RestController
@RequestMapping("/perfiles")
public class PerfilUsuarioController {
    @Autowired
    private PerfilUsuarioRepository repository;

    @GetMapping
    public List<PerfilUsuario> obtenerTodos() {
        return repository.findAll();
    }

    @PostMapping
    public PerfilUsuario registrar(@RequestBody PerfilUsuario perfil) {
        return repository.save(perfil);
    }

    @PutMapping("/{id}")
    public PerfilUsuario actualizar(@PathVariable Long id, @RequestBody PerfilUsuario perfil) {
        perfil.setId(id);
        return repository.save(perfil);
    }
@DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

