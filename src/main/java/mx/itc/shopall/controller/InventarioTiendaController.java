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
}
