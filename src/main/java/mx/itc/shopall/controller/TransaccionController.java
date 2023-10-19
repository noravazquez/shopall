package mx.itc.shopall.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}
