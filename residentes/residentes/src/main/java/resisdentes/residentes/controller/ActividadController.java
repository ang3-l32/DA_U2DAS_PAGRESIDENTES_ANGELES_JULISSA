package resisdentes.residentes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import resisdentes.residentes.model.*;
import resisdentes.residentes.repository.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:5173")
@RequestMapping("/actividades")
public class ActividadController {
    @Autowired
    private ActividadRepository repository;

    @GetMapping
    public List<Actividad> obtenerTodas() {
        return repository.findAll();
    }

    @PostMapping
    public Actividad crear(@RequestBody Actividad actividad) {
        return repository.save(actividad);
    }

    @PutMapping("/{id}")
    public Actividad actualizar(@PathVariable Long id, @RequestBody Actividad actividad) {
        actividad.setId(id);
        return repository.save(actividad);
    }
@DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}