package mx.itc.shopall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.itc.shopall.model.ComentarioTienda;
import mx.itc.shopall.repository.ComentarioTiendaRepository;

@Service
public class ComentarioTiendaService {
    @Autowired
    ComentarioTiendaRepository comentarioTiendaRepository;
    
    public List<ComentarioTienda> getAll(){
        List<ComentarioTienda> comentariosTienda = new ArrayList<>();
        for (ComentarioTienda comentarioTienda : comentarioTiendaRepository.findAll()) {
            comentariosTienda.add(comentarioTienda);
        }
        return comentariosTienda;
    }
    
    public void add(ComentarioTienda comentarioTienda){
        comentarioTiendaRepository.save(comentarioTienda);
    }
}
