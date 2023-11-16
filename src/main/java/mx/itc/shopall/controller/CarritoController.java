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

import mx.itc.shopall.model.Carrito;
import mx.itc.shopall.service.CarritoService;

@RestController
@RequestMapping("/carritos")
public class CarritoController {
    @Autowired
    CarritoService carritoService;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CarritoController.class);

    @PostMapping("/add")
    public void add(@RequestBody Carrito body){
        carritoService.add(body);
        LOGGER.info("Carrito agregado correctamente.");
    }
    
    @GetMapping("/getAll")
    public List<Carrito> getAll(){
        LOGGER.info("Carritos obtenidos correctamente.");
        return carritoService.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Carrito> getById(@PathVariable int id){
        Carrito carrito = carritoService.getById(id);
        if (carrito != null) {
            LOGGER.info("Registro encontrado correctamente.");
            return new ResponseEntity<>(carrito, HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Carrito carrito){
        Carrito oldCarrito = carritoService.getById(id);
        if (oldCarrito != null) {
            carritoService.update(id, carrito);
            LOGGER.info("Registro actualizado correctamente.");
            return new ResponseEntity<>("Registro actualizado correctamente", HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>("Registro no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        Carrito carrito = carritoService.getById(id);
        if (carrito != null) {
            carritoService.delete(id);
            LOGGER.info("Registro eliminado correctamente.");
            return new ResponseEntity<>("Registrado eliminado", HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>("Resgistro no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
