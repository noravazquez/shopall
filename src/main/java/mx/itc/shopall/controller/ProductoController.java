package mx.itc.shopall.controller;

import java.util.List;

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
    
    @PostMapping("/add")
    public void add(@RequestBody Producto body){
        productoService.add(body);
    }
    
    @GetMapping("/getAll")
    public List<Producto> getAll(){
        return productoService.getAll();
    }
}
