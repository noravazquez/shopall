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

import mx.itc.shopall.model.ResenaProducto;
import mx.itc.shopall.service.ResenaProductoService;

@RestController
@RequestMapping("/resenas_producto")
public class ResenaProductoController {
    @Autowired
    ResenaProductoService resenaProductoService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ResenaProductoController.class);
    
    @PostMapping("/add")
    public void add(@RequestBody ResenaProducto body){
        resenaProductoService.add(body);
        LOGGER.info("Resena del producto agregada correctamente.");
    }
    
    @GetMapping("/getAll")
    public List<ResenaProducto> getAll(){
        LOGGER.info("Resenas de producto obtenidas correctamente");
        return resenaProductoService.getAll();
    }
}
