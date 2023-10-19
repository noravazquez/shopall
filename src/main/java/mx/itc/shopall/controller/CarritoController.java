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

import mx.itc.shopall.model.Carrito;
import mx.itc.shopall.service.CarritoService;

@RestController
@RequestMapping("/carritos")
public class CarritoController {
    @Autowired
    CarritoService carritoService;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CarritoController.class);

    @PostMapping("/add")
    public void add(@RequestBody Carrito body){
        carritoService.add(body);
        LOGGER.info("Carrito agregado correctamente.");
    }
    
    @GetMapping("/getAll")
    public List<Carrito> getAll(){
        LOGGER.info("Carritos obtenidos correctamente.");
        return carritoService.getAll();
    }
}
