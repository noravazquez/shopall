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

import mx.itc.shopall.model.Transaccion;
import mx.itc.shopall.service.TransaccionService;

@RestController
@RequestMapping("/transacciones")
public class TransaccionController {
    @Autowired
    TransaccionService transaccionService;

    private static final Logger LOGGER = LoggerFactory.getLogger(TransaccionController.class);
    
    @PostMapping("/add")
    public void add(@RequestBody Transaccion body){
        transaccionService.add(body);
        LOGGER.info("Transaccion agregada correctamente.");
    }
    
    @GetMapping("/getAll")
    public List<Transaccion> getAll(){
        LOGGER.info("Transacciones obtenidas correctamente");
        return transaccionService.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Transaccion> getById(@PathVariable int id){
        Transaccion transaccion = transaccionService.getById(id);
        if (transaccion != null) {
            LOGGER.info("Registro encontrado correctamente.");
            return new ResponseEntity<>(transaccion, HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Transaccion transaccion){
        Transaccion oldTransaccion = transaccionService.getById(id);
        if (oldTransaccion != null) {
            transaccionService.update(id, transaccion);
            LOGGER.info("Registro actualizado correctamente.");
            return new ResponseEntity<>("Registro actualizado correctamente", HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>("Registro no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        Transaccion transaccion = transaccionService.getById(id);
        if (transaccion != null) {
            transaccionService.delete(id);
            LOGGER.info("Registro eliminado correctamente.");
            return new ResponseEntity<>("Registrado eliminado", HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>("Resgistro no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
