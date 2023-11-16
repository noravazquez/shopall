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

import mx.itc.shopall.model.InventarioTienda;
import mx.itc.shopall.service.InventarioTiendaService;

@RestController
@RequestMapping("/inventarios_tienda")
public class InventarioTiendaController {
    @Autowired
    InventarioTiendaService inventarioTiendaService;

    private static final Logger LOGGER = LoggerFactory.getLogger(InventarioTiendaController.class);
    
    @PostMapping("/add")
    public void add(@RequestBody InventarioTienda body){
        inventarioTiendaService.add(body);
        LOGGER.info("Inventario tienda agregado correctamente");
    }
    
    @GetMapping("/getAll")
    public List<InventarioTienda> getAll(){
        LOGGER.info("Inventarios de tienda obtenidos correctamente");
        return inventarioTiendaService.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<InventarioTienda> getById(@PathVariable int id){
        InventarioTienda inventarioTienda = inventarioTiendaService.getById(id);
        if (inventarioTienda != null) {
            LOGGER.info("Registro encontrado correctamente.");
            return new ResponseEntity<>(inventarioTienda, HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody InventarioTienda inventarioTienda){
        InventarioTienda oldInventarioTienda = inventarioTiendaService.getById(id);
        if (oldInventarioTienda != null) {
            inventarioTiendaService.update(id, inventarioTienda);
            LOGGER.info("Registro actualizado correctamente.");
            return new ResponseEntity<>("Registro actualizado correctamente", HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>("Registro no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        InventarioTienda inventarioTienda = inventarioTiendaService.getById(id);
        if (inventarioTienda != null) {
            inventarioTiendaService.delete(id);
            LOGGER.info("Registro eliminado correctamente.");
            return new ResponseEntity<>("Registrado eliminado", HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>("Resgistro no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
