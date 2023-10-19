package mx.itc.shopall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.itc.shopall.model.Categoria;
import mx.itc.shopall.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @PostMapping("/add")
    public void add(@RequestBody Categoria body){
        categoriaService.add(body);
    }

    @GetMapping("/getAll")
    public List<Categoria> getAll(){
        return categoriaService.getAll();
    }
}
