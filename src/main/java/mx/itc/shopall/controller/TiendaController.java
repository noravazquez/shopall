package mx.itc.shopall.controller;

import java.util.List;

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
    
    @PostMapping("/add")
    public void add(@RequestBody Tienda body){
        tiendaService.add(body);
    }
    
    @GetMapping("/getAll")
    public List<Tienda> getAll(){
        return tiendaService.getAll();
    }
}
