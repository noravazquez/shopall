package mx.itc.shopall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.itc.shopall.model.Vendedor;
import mx.itc.shopall.service.VendedorService;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {
    @Autowired
    VendedorService vendedorService;

    @PostMapping("/add")
    public void add(@RequestBody Vendedor bodyVendedor){
        vendedorService.add(bodyVendedor);
    }

    @GetMapping("/getAll")
    public List<Vendedor> getAll(){
        return vendedorService.getAll();
    }
}
