package mx.itc.shopall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.itc.shopall.model.Modulo;
import mx.itc.shopall.service.ModuloService;

@RestController
@RequestMapping("/modulos")
public class ModuloController {
    @Autowired
    ModuloService moduloService;

    @GetMapping("/getAll")
    public List<Modulo> getAll(){
        return moduloService.getAll();
    }  
}
