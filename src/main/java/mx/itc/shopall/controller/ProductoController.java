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

import mx.itc.shopall.model.Producto;
import mx.itc.shopall.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    ProductoService productoService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);
    
    @PostMapping("/add")
    public void add(@RequestBody Producto body){
        productoService.add(body);
        LOGGER.info("Producto agregado correctamente.");
    }
    
    @GetMapping("/getAll")
    public List<Producto> getAll(){
        LOGGER.info("Productos obtenidos correctamente.");
        return productoService.getAll();
    }
}
