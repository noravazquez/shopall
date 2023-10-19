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

import mx.itc.shopall.model.ComentarioTienda;
import mx.itc.shopall.service.ComentarioTiendaService;

@RestController
@RequestMapping("/comentarios_tienda")
public class ComentarioTiendaController {
    @Autowired
    ComentarioTiendaService comentarioTiendaService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ComentarioTiendaController.class);
    
    @PostMapping("/add")
    public void add(@RequestBody ComentarioTienda body){
        comentarioTiendaService.add(body);
        LOGGER.info("Comentario de tienda agregado correctamente.");
    }
    
    @GetMapping("/getAll")
    public List<ComentarioTienda> getAll(){
        LOGGER.info("Comentarios de tienda obtenidos correctamente.");
        return comentarioTiendaService.getAll();
    }
}
