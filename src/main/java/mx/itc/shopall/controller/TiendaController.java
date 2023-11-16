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

import mx.itc.shopall.model.Tienda;
import mx.itc.shopall.service.TiendaService;

@RestController
@RequestMapping("/tiendas")
public class TiendaController {
    @Autowired
    TiendaService tiendaService;

    private static final Logger LOGGER = LoggerFactory.getLogger(TiendaController.class);
    
    @PostMapping("/add")
    public void add(@RequestBody Tienda body){
        tiendaService.add(body);
        LOGGER.info("Tienda agregada correctamente.");
    }
    
    @GetMapping("/getAll")
    public List<Tienda> getAll(){
        LOGGER.info("Tiendas obtenidas correctamente.");
        return tiendaService.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Tienda> getById(@PathVariable int id){
        Tienda tienda = tiendaService.getById(id);
        if (tienda != null) {
            LOGGER.info("Registro encontrado correctamente.");
            return new ResponseEntity<>(tienda, HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Tienda tienda){
        Tienda oldTienda = tiendaService.getById(id);
        if (oldTienda != null) {
            tiendaService.update(id, tienda);
            LOGGER.info("Registro actualizado correctamente.");
            return new ResponseEntity<>("Registro actualizado correctamente", HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>("Registro no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        Tienda tienda = tiendaService.getById(id);
        if (tienda != null) {
            tiendaService.delete(id);
            LOGGER.info("Registro eliminado correctamente.");
            return new ResponseEntity<>("Registrado eliminado", HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>("Resgistro no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
