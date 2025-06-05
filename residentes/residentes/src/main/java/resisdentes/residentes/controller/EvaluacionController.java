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

import resisdentes.residentes.model.Evaluacion;
import resisdentes.residentes.repository.EvaluacionRepository;
@RestController
@CrossOrigin(origins="http://localhost:5173")
@RequestMapping("/evaluaciones")
public class EvaluacionController {
    @Autowired
    private EvaluacionRepository repository;

    @GetMapping
    public List<Evaluacion> obtenerTodas() {
        return repository.findAll();
    }

    @PostMapping
    public Evaluacion crear(@RequestBody Evaluacion evaluacion) {
        return repository.save(evaluacion);
    }

    @PutMapping("/{id}")
    public Evaluacion actualizar(@PathVariable Long id, @RequestBody Evaluacion evaluacion) {
        evaluacion.setId(id);
        return repository.save(evaluacion);
    }
@DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
