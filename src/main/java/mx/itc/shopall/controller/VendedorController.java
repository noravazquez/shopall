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

import mx.itc.shopall.model.Vendedor;
import mx.itc.shopall.service.VendedorService;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {
    @Autowired
    VendedorService vendedorService;

    private static final Logger LOGGER = LoggerFactory.getLogger(VendedorController.class);

    @PostMapping("/add")
    public void add(@RequestBody Vendedor bodyVendedor){
        vendedorService.add(bodyVendedor);
        LOGGER.info("Vendedor agregado correctamente.");
    }

    @GetMapping("/getAll")
    public List<Vendedor> getAll(){
        LOGGER.info("Vendedores obtenidos correctamente.");
        return vendedorService.getAll();
    }
}
