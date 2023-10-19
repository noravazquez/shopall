package mx.itc.shopall.controller;

import java.util.List;

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
    
    @PostMapping("/add")
    public void add(@RequestBody InventarioTienda body){
        inventarioTiendaService.add(body);
    }
    
    @GetMapping("/getAll")
    public List<InventarioTienda> getAll(){
        return inventarioTiendaService.getAll();
    }
}
