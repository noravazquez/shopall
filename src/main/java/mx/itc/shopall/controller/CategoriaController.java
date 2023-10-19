package mx.itc.shopall.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOG = LoggerFactory.getLogger(CategoriaController.class);

    @PostMapping("/add")
    public void add(@RequestBody Categoria body){
        categoriaService.add(body);
        LOG.info("Categoria agregada correctamente.");
    }

    @GetMapping("/getAll")
    public List<Categoria> getAll(){
        LOG.info("Categorias obtenidas correctamente.");
        return categoriaService.getAll();
    }
}
