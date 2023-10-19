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

import mx.itc.shopall.model.DetalleCarrito;
import mx.itc.shopall.service.DetalleCarritoService;

@RestController
@RequestMapping("/detallesCarrito")
public class DetalleCarritoContoller {
    @Autowired
    DetalleCarritoService detalleCarritoService;

    private static final Logger LOGGER = LoggerFactory.getLogger(DetalleCarritoContoller.class);
    
    @PostMapping("/add")
    public void add(@RequestBody DetalleCarrito body){
        LOGGER.info("Detalle carrito agregado correctamente.");
        detalleCarritoService.add(body);
    }
    
    @GetMapping("/getAll")
    public List<DetalleCarrito> getAll(){
        LOGGER.info("Detalles de carrito obtenidos correctamente.");
        return detalleCarritoService.getAll();
    }
}
