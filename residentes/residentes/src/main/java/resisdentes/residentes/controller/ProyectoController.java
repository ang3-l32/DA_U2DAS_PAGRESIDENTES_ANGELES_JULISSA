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

import resisdentes.residentes.model.Proyecto;
import resisdentes.residentes.repository.ProyectoRepository;

@RestController
@RequestMapping("/proyectos")
public class ProyectoController {
    @Autowired
    private ProyectoRepository repository;

    @GetMapping
    public List<Proyecto> obtenerTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Proyecto crear(@RequestBody Proyecto proyecto) {
        return repository.save(proyecto);
    }

    @PutMapping("/{id}")
    public Proyecto actualizar(@PathVariable Long id, @RequestBody Proyecto proyecto) {
        proyecto.setId(id);
        return repository.save(proyecto);
    }
@DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
