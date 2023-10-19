package mx.itc.shopall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.itc.shopall.model.InventarioTienda;
import mx.itc.shopall.repository.InventarioTiendaRepository;

@Service
public class InventarioTiendaService {
    @Autowired
    InventarioTiendaRepository inventarioTiendaRepository;
    
    public List<InventarioTienda> getAll(){
        List<InventarioTienda> inventariosTienda = new ArrayList<>();
        for (InventarioTienda inventarioTienda : inventarioTiendaRepository.findAll()) {
            inventariosTienda.add(inventarioTienda);
        }
        return inventariosTienda;
    }
    
    public void add(InventarioTienda inventarioTienda){
        inventarioTiendaRepository.save(inventarioTienda);
    }
}
