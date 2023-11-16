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

import mx.itc.shopall.model.ResenaProducto;
import mx.itc.shopall.service.ResenaProductoService;

@RestController
@RequestMapping("/resenas_producto")
public class ResenaProductoController {
    @Autowired
    ResenaProductoService resenaProductoService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ResenaProductoController.class);
    
    @PostMapping("/add")
    public void add(@RequestBody ResenaProducto body){
        resenaProductoService.add(body);
        LOGGER.info("Resena del producto agregada correctamente.");
    }
    
    @GetMapping("/getAll")
    public List<ResenaProducto> getAll(){
        LOGGER.info("Resenas de producto obtenidas correctamente");
        return resenaProductoService.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResenaProducto> getById(@PathVariable int id){
        ResenaProducto resenaProducto = resenaProductoService.getById(id);
        if (resenaProducto != null) {
            LOGGER.info("Registro encontrado correctamente.");
            return new ResponseEntity<>(resenaProducto, HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody ResenaProducto resenaProducto){
        ResenaProducto oldResenaProducto = resenaProductoService.getById(id);
        if (oldResenaProducto != null) {
            resenaProductoService.update(id, resenaProducto);
            LOGGER.info("Registro actualizado correctamente.");
            return new ResponseEntity<>("Registro actualizado correctamente", HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>("Registro no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        ResenaProducto resenaProducto = resenaProductoService.getById(id);
        if (resenaProducto != null) {
            resenaProductoService.delete(id);
            LOGGER.info("Registro eliminado correctamente.");
            return new ResponseEntity<>("Registrado eliminado", HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>("Resgistro no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
