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

import mx.itc.shopall.model.ComentarioProducto;
import mx.itc.shopall.service.ComentarioProductoService;

@RestController
@RequestMapping("/comentarios_producto")
public class ComentarioProductoController {
    @Autowired
    ComentarioProductoService comentarioProductoService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ComentarioProductoController.class);
    
    @PostMapping("/add")
    public void add(@RequestBody ComentarioProducto body){
        comentarioProductoService.add(body);
        LOGGER.info("Comentario de producto agregado correctamente.");
    }
    
    @GetMapping("/getAll")
    public List<ComentarioProducto> getAll(){
        LOGGER.info("Comentarios de producto obtenidos correctamente.");
        return comentarioProductoService.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ComentarioProducto> getById(@PathVariable int id){
        ComentarioProducto comentarioProducto = comentarioProductoService.getById(id);
        if (comentarioProducto != null) {
            LOGGER.info("Registro encontrado correctamente.");
            return new ResponseEntity<>(comentarioProducto, HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody ComentarioProducto comentarioProducto){
        ComentarioProducto oldcComentarioProducto = comentarioProductoService.getById(id);
        if (oldcComentarioProducto != null) {
            comentarioProductoService.update(id, comentarioProducto);
            LOGGER.info("Registro actualizado correctamente.");
            return new ResponseEntity<>("Registro actualizado correctamente", HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>("Registro no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        ComentarioProducto comentarioProducto = comentarioProductoService.getById(id);
        if (comentarioProducto != null) {
            comentarioProductoService.delete(id);
            LOGGER.info("Registro eliminado correctamente.");
            return new ResponseEntity<>("Registrado eliminado", HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>("Resgistro no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
