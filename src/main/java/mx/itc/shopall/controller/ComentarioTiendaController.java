package mx.itc.shopall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.itc.shopall.model.ComentarioTienda;
import mx.itc.shopall.service.ComentarioTiendaService;

@RestController
@RequestMapping("/comentarios_tienda")
public class ComentarioTiendaController {
    @Autowired
    ComentarioTiendaService comentarioTiendaService;
    
    @PostMapping("/add")
    public void add(@RequestBody ComentarioTienda body){
        comentarioTiendaService.add(body);
    }
    
    @GetMapping("/getAll")
    public List<ComentarioTienda> getAll(){
        return comentarioTiendaService.getAll();
    }
}
