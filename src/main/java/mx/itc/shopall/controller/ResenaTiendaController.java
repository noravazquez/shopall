package mx.itc.shopall.controller;

import java.util.List;

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
    
    @PostMapping("/add")
    public void add(@RequestBody ResenaTienda body){
        resenaTiendaService.add(body);
    }
    
    @GetMapping("/getAll")
    public List<ResenaTienda> getAll(){
        return resenaTiendaService.getAll();
    }
}
