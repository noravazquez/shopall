package mx.itc.shopall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.itc.shopall.model.Metodo;
import mx.itc.shopall.service.MetodoService;

@RestController
@RequestMapping("/metodos")
public class MetodoController {
    @Autowired
    MetodoService metodoService;

    @GetMapping("/getAll")
    public List<Metodo> getAll(){
        return metodoService.getAll();
    }  
}
