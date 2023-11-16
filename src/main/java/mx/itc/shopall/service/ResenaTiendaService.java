package mx.itc.shopall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.itc.shopall.model.ResenaTienda;
import mx.itc.shopall.repository.ResenaTiendaRepository;

@Service
public class ResenaTiendaService {
    @Autowired
    ResenaTiendaRepository resenaTiendaRepository;
    
    public List<ResenaTienda> getAll(){
        List<ResenaTienda> resenasTienda = new ArrayList<>();
        for (ResenaTienda resenaTienda : resenaTiendaRepository.findAll()) {
            resenasTienda.add(resenaTienda);
        }
        return resenasTienda;
    }
    
    public void add(ResenaTienda resenaTienda){
        resenaTiendaRepository.save(resenaTienda);
    }

    public ResenaTienda getById(int id){
        return resenaTiendaRepository.findById(id).orElse(null);
    }

    public void update(int id, ResenaTienda resenaTienda){
        if (resenaTiendaRepository.existsById(id)) {
            resenaTienda.setId_resena(id);
            resenaTiendaRepository.save(resenaTienda);
        }
    }

    public void delete(int id){
        resenaTiendaRepository.deleteById(id);
    }
}
