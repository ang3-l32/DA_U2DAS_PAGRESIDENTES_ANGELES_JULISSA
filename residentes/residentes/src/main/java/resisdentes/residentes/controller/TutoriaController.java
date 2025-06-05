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

import resisdentes.residentes.model.Tutoria;
import resisdentes.residentes.repository.TutoriaRepository;

@RestController
@RequestMapping("/tutorias")
public class TutoriaController {
    @Autowired
    private TutoriaRepository repository;

    @GetMapping
    public List<Tutoria> obtenerTodas() {
        return repository.findAll();
    }

    @PostMapping
    public Tutoria crear(@RequestBody Tutoria tutoria) {
        return repository.save(tutoria);
    }

    @PutMapping("/{id}")
    public Tutoria actualizar(@PathVariable Long id, @RequestBody Tutoria tutoria) {
        tutoria.setId(id);
        return repository.save(tutoria);
    }
@DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
