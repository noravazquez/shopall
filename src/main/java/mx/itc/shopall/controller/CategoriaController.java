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

import mx.itc.shopall.model.Categoria;
import mx.itc.shopall.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriaController.class);

    @PostMapping("/add")
    public void add(@RequestBody Categoria body) throws Exception{
        categoriaService.add(body);
        LOGGER.info("Categoria agregada correctamente.");
    }

    @GetMapping("/getAll")
    public List<Categoria> getAll(){
        LOGGER.info("Categorias obtenidas correctamente.");
        return categoriaService.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Categoria> getById(@PathVariable int id){
        Categoria categoria = categoriaService.getById(id);
        if (categoria != null) {
            LOGGER.info("Registro encontrado correctamente.");
            return new ResponseEntity<>(categoria, HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Categoria categoria){
        Categoria oldCategoria = categoriaService.getById(id);
        if (oldCategoria != null) {
            categoriaService.update(id, categoria);
            LOGGER.info("Registro actualizado correctamente.");
            return new ResponseEntity<>("Registro actualizado correctamente", HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>("Registro no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        Categoria categoria = categoriaService.getById(id);
        if (categoria != null) {
            categoriaService.delete(id);
            LOGGER.info("Registro eliminado correctamente.");
            return new ResponseEntity<>("Registrado eliminado", HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>("Resgistro no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
