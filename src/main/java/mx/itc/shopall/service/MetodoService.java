package mx.itc.shopall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.itc.shopall.model.Metodo;
import mx.itc.shopall.repository.MetodoRepository;

@Service
public class MetodoService {
    @Autowired
    MetodoRepository metodoRepository;

    public List<Metodo> getAll(){
        List<Metodo> metodos = new ArrayList<>();
        for(Metodo metodo : metodoRepository.findAll()){
            metodos.add(metodo);
        }
        return metodos;
    }
}
