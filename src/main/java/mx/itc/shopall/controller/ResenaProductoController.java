package mx.itc.shopall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.itc.shopall.model.ResenaProducto;
import mx.itc.shopall.service.ResenaProductoService;

@RestController
@RequestMapping("/resenas_producto")
public class ResenaProductoController {
    @Autowired
    ResenaProductoService resenaProductoService;
    
    @PostMapping("/add")
    public void add(@RequestBody ResenaProducto body){
        resenaProductoService.add(body);
    }
    
    @GetMapping("/getAll")
    public List<ResenaProducto> getAll(){
        return resenaProductoService.getAll();
    }
}
