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
}
