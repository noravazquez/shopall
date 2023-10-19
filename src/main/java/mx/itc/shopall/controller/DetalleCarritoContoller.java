package mx.itc.shopall.controller;

import java.util.List;

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
    
    @PostMapping("/add")
    public void add(@RequestBody DetalleCarrito body){
        detalleCarritoService.add(body);
    }
    
    @GetMapping("/getAll")
    public List<DetalleCarrito> getAll(){
        return detalleCarritoService.getAll();
    }
}
