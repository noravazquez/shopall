package mx.itc.shopall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.itc.shopall.model.Transaccion;
import mx.itc.shopall.repository.TransaccionRepository;

@Service
public class TransaccionService {
    @Autowired
    TransaccionRepository transaccionRepository;
    
    public List<Transaccion> getAll(){
        List<Transaccion> transacciones = new ArrayList<>();
        for (Transaccion transaccion : transaccionRepository.findAll()) {
            transacciones.add(transaccion);
        }
        return transacciones;
    }
    
    public void add(Transaccion transaccion){
        transaccionRepository.save(transaccion);
    }
}
