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
}
