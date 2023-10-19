package mx.itc.shopall.controller;

import java.util.List;

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
    
    @PostMapping("/add")
    public void add(@RequestBody Carrito body){
        carritoService.add(body);
    }
    
    @GetMapping("/getAll")
    public List<Carrito> getAll(){
        return carritoService.getAll();
    }
}
