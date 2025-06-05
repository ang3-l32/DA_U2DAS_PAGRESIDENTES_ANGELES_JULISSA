package resisdentes.residentes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import resisdentes.residentes.model.Incidencia;
import resisdentes.residentes.repository.IncidenciaRepository;

@RestController
@RequestMapping("/incidencias")
@CrossOrigin(origins="http://localhost:5173")
public class IncidenciaController {
    @Autowired
    private IncidenciaRepository repository;

    @GetMapping
    public List<Incidencia> obtenerTodas() {
        return repository.findAll();
    }

    @PostMapping
    public Incidencia crear(@RequestBody Incidencia incidencia) {
        return repository.save(incidencia);
    }

    @PutMapping("/{id}")
    public Incidencia actualizar(@PathVariable Long id, @RequestBody Incidencia incidencia) {
        incidencia.setId(id);
        return repository.save(incidencia);
    }

@DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
