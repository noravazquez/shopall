package mx.itc.shopall.controller;

import java.util.List;

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

    @PostMapping("/add")
    public void add(@RequestBody Comprador bodyComprador){
        compradorService.add(bodyComprador);
    }

    @GetMapping("/getAll")
    public List<Comprador> getAll(){
        return compradorService.getAll();
    }
}
