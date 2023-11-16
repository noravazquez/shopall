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

import mx.itc.shopall.model.DetalleCarrito;
import mx.itc.shopall.service.DetalleCarritoService;

@RestController
@RequestMapping("/detallesCarrito")
public class DetalleCarritoContoller {
    @Autowired
    DetalleCarritoService detalleCarritoService;

    private static final Logger LOGGER = LoggerFactory.getLogger(DetalleCarritoContoller.class);
    
    @PostMapping("/add")
    public void add(@RequestBody DetalleCarrito body){
        LOGGER.info("Detalle carrito agregado correctamente.");
        detalleCarritoService.add(body);
    }
    
    @GetMapping("/getAll")
    public List<DetalleCarrito> getAll(){
        LOGGER.info("Detalles de carrito obtenidos correctamente.");
        return detalleCarritoService.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<DetalleCarrito> getById(@PathVariable int id){
        DetalleCarrito detalleCarrito = detalleCarritoService.getById(id);
        if (detalleCarrito != null) {
            LOGGER.info("Registro encontrado correctamente.");
            return new ResponseEntity<>(detalleCarrito, HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody DetalleCarrito detalleCarrito){
        DetalleCarrito oldDetalleCarrito = detalleCarritoService.getById(id);
        if (oldDetalleCarrito != null) {
            detalleCarritoService.update(id, detalleCarrito);
            LOGGER.info("Registro actualizado correctamente.");
            return new ResponseEntity<>("Registro actualizado correctamente", HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>("Registro no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        DetalleCarrito detalleCarrito = detalleCarritoService.getById(id);
        if (detalleCarrito != null) {
            detalleCarritoService.delete(id);
            LOGGER.info("Registro eliminado correctamente.");
            return new ResponseEntity<>("Registrado eliminado", HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>("Resgistro no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
