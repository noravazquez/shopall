package mx.itc.shopall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.itc.shopall.model.Transaccion;
import mx.itc.shopall.service.TransaccionService;

@RestController
@RequestMapping("/transacciones")
public class TransaccionController {
    @Autowired
    TransaccionService transaccionService;
    
    @PostMapping("/add")
    public void add(@RequestBody Transaccion body){
        transaccionService.add(body);
    }
    
    @GetMapping("/getAll")
    public List<Transaccion> getAll(){
        return transaccionService.getAll();
    }
}
