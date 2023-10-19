package mx.itc.shopall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.itc.shopall.model.Tienda;
import mx.itc.shopall.repository.TiendaRepository;

@Service
public class TiendaService {
    @Autowired
    TiendaRepository tiendaRepository;
    
    public List<Tienda> getAll(){
        List<Tienda> tiendas = new ArrayList<>();
        for (Tienda tienda : tiendaRepository.findAll()) {
            tiendas.add(tienda);
        }
        return tiendas;
    }
    
    public void add(Tienda tienda){
        tiendaRepository.save(tienda);
    }
}
