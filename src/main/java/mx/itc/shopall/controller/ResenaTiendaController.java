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
}
