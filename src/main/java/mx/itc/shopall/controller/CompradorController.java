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

import mx.itc.shopall.model.Comprador;
import mx.itc.shopall.service.CompradorService;

@RestController
@RequestMapping("/compradores")
public class CompradorController {
    @Autowired
    CompradorService compradorService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CompradorController.class);

    @PostMapping("/add")
    public void add(@RequestBody Comprador bodyComprador){
        compradorService.add(bodyComprador);
        LOGGER.info("Comprador agregado correctamente.");
    }

    @GetMapping("/getAll")
    public List<Comprador> getAll(){
        LOGGER.info("Compradores obtenidos correctamente");
        return compradorService.getAll();
    }
}
