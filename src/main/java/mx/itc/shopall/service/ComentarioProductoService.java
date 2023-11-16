package mx.itc.shopall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.itc.shopall.model.ComentarioProducto;
import mx.itc.shopall.repository.ComentarioProductoRepository;

@Service
public class ComentarioProductoService {
    @Autowired
    ComentarioProductoRepository comentarioProductoRepository;
    
    public List<ComentarioProducto> getAll(){
        List<ComentarioProducto> comentariosProducto = new ArrayList<>();
        for (ComentarioProducto comentarioProducto : comentarioProductoRepository.findAll()) {
            comentariosProducto.add(comentarioProducto);
        }
        return comentariosProducto;
    }
    
    public void add(ComentarioProducto comentarioProducto){
        comentarioProductoRepository.save(comentarioProducto);
    }

    public ComentarioProducto getById(int id){
        return comentarioProductoRepository.findById(id).orElse(null);
    }

    public void update(int id, ComentarioProducto comentarioProducto){
        if (comentarioProductoRepository.existsById(id)) {
            comentarioProducto.setId_comentario(id);
            comentarioProductoRepository.save(comentarioProducto);
        }
    }

    public void delete(int id){
        comentarioProductoRepository.deleteById(id);
    }
}
