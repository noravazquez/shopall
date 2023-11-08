package mx.itc.shopall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.itc.shopall.model.Rol;
import mx.itc.shopall.service.RolService;

@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    RolService rolService;

    @GetMapping("/getAll")
    public List<Rol> getAll(){
        return rolService.getAll();
    }  
}
