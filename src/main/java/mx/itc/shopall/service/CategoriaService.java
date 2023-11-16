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

    public Categoria getById(int id){
        return categoriaRepository.findById(id).orElse(null);
    }

    public void update(int id, Categoria categoria){
        if (categoriaRepository.existsById(id)) {
            categoria.setId_categoria(id);
            categoriaRepository.save(categoria);
        }
    }

    public void delete(int id){
        categoriaRepository.deleteById(id);
    }
}
