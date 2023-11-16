package mx.itc.shopall.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.itc.shopall.model.Persona;
import mx.itc.shopall.service.PersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    @Autowired
    PersonaService personaService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonaController.class);

    @PostMapping("/add")
    public void add(@RequestBody Persona body) throws Exception{
        personaService.add(body);
        LOGGER.info("Persona agregada correctamente.");
    }

    @GetMapping("/getAll")
    public List<Persona> getAll(){
        LOGGER.info("Personas obtenidas correctamente.");
        return personaService.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Persona> getById(@PathVariable int id){
        Persona persona = personaService.getById(id);
        if (persona != null) {
            LOGGER.info("Registro encontrado correctamente.");
            return new ResponseEntity<>(persona, HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Persona persona){
        Persona oldPersona = personaService.getById(id);
        if (oldPersona != null) {
            personaService.update(id, persona);
            LOGGER.info("Registro actualizado correctamente.");
            return new ResponseEntity<>("Registro actualizado correctamente", HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>("Registro no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        Persona persona = personaService.getById(id);
        if (persona != null) {
            personaService.delete(id);
            LOGGER.info("Registro eliminado correctamente.");
            return new ResponseEntity<>("Registrado eliminado", HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>("Resgistro no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
