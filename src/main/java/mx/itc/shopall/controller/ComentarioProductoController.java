package mx.itc.shopall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.itc.shopall.model.ComentarioProducto;
import mx.itc.shopall.service.ComentarioProductoService;

@RestController
@RequestMapping("/comentarios_producto")
public class ComentarioProductoController {
    @Autowired
    ComentarioProductoService comentarioProductoService;
    
    @PostMapping("/add")
    public void add(@RequestBody ComentarioProducto body){
        comentarioProductoService.add(body);
    }
    
    @GetMapping("/getAll")
    public List<ComentarioProducto> getAll(){
        return comentarioProductoService.getAll();
    }
}
