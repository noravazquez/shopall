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

import mx.itc.shopall.model.ComentarioProducto;
import mx.itc.shopall.service.ComentarioProductoService;

@RestController
@RequestMapping("/comentarios_producto")
public class ComentarioProductoController {
    @Autowired
    ComentarioProductoService comentarioProductoService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ComentarioProductoController.class);
    
    @PostMapping("/add")
    public void add(@RequestBody ComentarioProducto body){
        comentarioProductoService.add(body);
        LOGGER.info("Comentario de producto agregado correctamente.");
    }
    
    @GetMapping("/getAll")
    public List<ComentarioProducto> getAll(){
        LOGGER.info("Comentarios de producto obtenidos correctamente.");
        return comentarioProductoService.getAll();
    }
}
