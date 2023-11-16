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

import mx.itc.shopall.model.ComentarioTienda;
import mx.itc.shopall.service.ComentarioTiendaService;

@RestController
@RequestMapping("/comentarios_tienda")
public class ComentarioTiendaController {
    @Autowired
    ComentarioTiendaService comentarioTiendaService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ComentarioTiendaController.class);
    
    @PostMapping("/add")
    public void add(@RequestBody ComentarioTienda body){
        comentarioTiendaService.add(body);
        LOGGER.info("Comentario de tienda agregado correctamente.");
    }
    
    @GetMapping("/getAll")
    public List<ComentarioTienda> getAll(){
        LOGGER.info("Comentarios de tienda obtenidos correctamente.");
        return comentarioTiendaService.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ComentarioTienda> getById(@PathVariable int id){
        ComentarioTienda comentarioTienda = comentarioTiendaService.getById(id);
        if (comentarioTienda != null) {
            LOGGER.info("Registro encontrado correctamente.");
            return new ResponseEntity<>(comentarioTienda, HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody ComentarioTienda comentarioTienda){
        ComentarioTienda oldComentarioTienda = comentarioTiendaService.getById(id);
        if (oldComentarioTienda != null) {
            comentarioTiendaService.update(id, comentarioTienda);
            LOGGER.info("Registro actualizado correctamente.");
            return new ResponseEntity<>("Registro actualizado correctamente", HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>("Registro no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        ComentarioTienda comentarioTienda = comentarioTiendaService.getById(id);
        if (comentarioTienda != null) {
            comentarioTiendaService.delete(id);
            LOGGER.info("Registro eliminado correctamente.");
            return new ResponseEntity<>("Registrado eliminado", HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>("Resgistro no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
