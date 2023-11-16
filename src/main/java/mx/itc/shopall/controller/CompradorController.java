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

import mx.itc.shopall.model.Comprador;
import mx.itc.shopall.service.CompradorService;

@RestController
@RequestMapping("/compradores")
public class CompradorController {
    @Autowired
    CompradorService compradorService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CompradorController.class);

    @PostMapping("/add")
    public void add(@RequestBody Comprador bodyComprador){
        compradorService.add(bodyComprador);
        LOGGER.info("Comprador agregado correctamente.");
    }

    @GetMapping("/getAll")
    public List<Comprador> getAll(){
        LOGGER.info("Compradores obtenidos correctamente");
        return compradorService.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Comprador> getById(@PathVariable int id){
        Comprador comprador = compradorService.getById(id);
        if (comprador != null) {
            LOGGER.info("Registro encontrado correctamente.");
            return new ResponseEntity<>(comprador, HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Comprador comprador){
        Comprador oldComprador = compradorService.getById(id);
        if (oldComprador != null) {
            compradorService.update(id, comprador);
            LOGGER.info("Registro actualizado correctamente.");
            return new ResponseEntity<>("Registro actualizado correctamente", HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>("Registro no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        Comprador comprador = compradorService.getById(id);
        if (comprador != null) {
            compradorService.delete(id);
            LOGGER.info("Registro eliminado correctamente.");
            return new ResponseEntity<>("Registrado eliminado", HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>("Resgistro no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
