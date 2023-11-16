package mx.itc.shopall;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import mx.itc.shopall.model.Categoria;
import mx.itc.shopall.service.CategoriaService;

@SpringBootTest
public class CategoriaControllerTest{
    @Autowired
    CategoriaService categoriaService;

    @Test
    public void get(){
        List<Categoria> categorias = new ArrayList<>();

        categorias.addAll(categoriaService.getAll());

        Assertions.assertTrue(categorias.size() > 0);
    }
}