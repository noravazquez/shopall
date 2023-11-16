package mx.itc.shopall.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/get/{id}")
    public ResponseEntity<Vendedor> getById(@PathVariable int id){
        Vendedor vendedor = vendedorService.getById(id);
        if (vendedor != null) {
            LOGGER.info("Registro encontrado correctamente.");
            return new ResponseEntity<>(vendedor, HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Vendedor vendedor){
        Vendedor oldVendedor = vendedorService.getById(id);
        if (oldVendedor != null) {
            vendedorService.update(id, vendedor);
            LOGGER.info("Registro actualizado correctamente.");
            return new ResponseEntity<>("Registro actualizado correctamente", HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>("Registro no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        Vendedor vendedor = vendedorService.getById(id);
        if (vendedor != null) {
            vendedorService.delete(id);
            LOGGER.info("Registro eliminado correctamente.");
            return new ResponseEntity<>("Registrado eliminado", HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>("Resgistro no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
