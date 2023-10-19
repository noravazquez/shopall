package mx.itc.shopall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.itc.shopall.model.Categoria;
import mx.itc.shopall.repository.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

    public List<Categoria> getAll(){
        List<Categoria> categorias = new ArrayList<>();
        for(Categoria categoria : categoriaRepository.findAll()){
            categorias.add(categoria);
        }
        return categorias;
    }

    public void add(Categoria categoria){
        categoriaRepository.save(categoria);
    }
}
