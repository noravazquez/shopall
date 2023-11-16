package mx.itc.shopall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.itc.shopall.model.Comprador;
import mx.itc.shopall.repository.CompradorRepository;

@Service
public class CompradorService {
    @Autowired
    CompradorRepository compradorRepository;

    public List<Comprador> getAll(){
        List<Comprador> compradores = new ArrayList<>();
        for(Comprador comprador : compradorRepository.findAll()){
            compradores.add(comprador);
        }
        return compradores;
    }

    public void add(Comprador comprador){
        compradorRepository.save(comprador);
    }

    public Comprador getById(int id){
        return compradorRepository.findById(id).orElse(null);
    }

    public void update(int id, Comprador comprador){
        if (compradorRepository.existsById(id)) {
            comprador.setId_comprador(id);
            compradorRepository.save(comprador);
        }
    }

    public void delete(int id){
        compradorRepository.deleteById(id);
    }
}
