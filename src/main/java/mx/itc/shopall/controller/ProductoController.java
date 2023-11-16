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

import mx.itc.shopall.model.Producto;
import mx.itc.shopall.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    ProductoService productoService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);
    
    @PostMapping("/add")
    public void add(@RequestBody Producto body){
        productoService.add(body);
        LOGGER.info("Producto agregado correctamente.");
    }
    
    @GetMapping("/getAll")
    public List<Producto> getAll(){
        LOGGER.info("Productos obtenidos correctamente.");
        return productoService.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Producto> getById(@PathVariable int id){
        Producto producto = productoService.getById(id);
        if (producto != null) {
            LOGGER.info("Registro encontrado correctamente.");
            return new ResponseEntity<>(producto, HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Producto producto){
        Producto oldProducto = productoService.getById(id);
        if (oldProducto != null) {
            productoService.update(id, producto);
            LOGGER.info("Registro actualizado correctamente.");
            return new ResponseEntity<>("Registro actualizado correctamente", HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>("Registro no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        Producto producto = productoService.getById(id);
        if (producto != null) {
            productoService.delete(id);
            LOGGER.info("Registro eliminado correctamente.");
            return new ResponseEntity<>("Registrado eliminado", HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>("Resgistro no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
