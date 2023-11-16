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

import mx.itc.shopall.model.ResenaTienda;
import mx.itc.shopall.service.ResenaTiendaService;

@RestController
@RequestMapping("/resenas_tienda")
public class ResenaTiendaController {
    @Autowired
    ResenaTiendaService resenaTiendaService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ResenaTiendaController.class);
    
    @PostMapping("/add")
    public void add(@RequestBody ResenaTienda body){
        resenaTiendaService.add(body);
        LOGGER.info("Resena de tienda agregada correctamente.");
    }
    
    @GetMapping("/getAll")
    public List<ResenaTienda> getAll(){
        LOGGER.info("Resenas de tienda obtenidas correctamente.");
        return resenaTiendaService.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResenaTienda> getById(@PathVariable int id){
        ResenaTienda resenaTienda = resenaTiendaService.getById(id);
        if (resenaTienda != null) {
            LOGGER.info("Registro encontrado correctamente.");
            return new ResponseEntity<>(resenaTienda, HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody ResenaTienda resenaTienda){
        ResenaTienda oldResenaTienda = resenaTiendaService.getById(id);
        if (oldResenaTienda != null) {
            resenaTiendaService.update(id, resenaTienda);
            LOGGER.info("Registro actualizado correctamente.");
            return new ResponseEntity<>("Registro actualizado correctamente", HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>("Registro no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        ResenaTienda resenaTienda = resenaTiendaService.getById(id);
        if (resenaTienda != null) {
            resenaTiendaService.delete(id);
            LOGGER.info("Registro eliminado correctamente.");
            return new ResponseEntity<>("Registrado eliminado", HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>("Resgistro no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
