package mx.itc.shopall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.itc.shopall.model.Carrito;
import mx.itc.shopall.repository.CarritoRepository;

@Service
public class CarritoService {
    @Autowired
    CarritoRepository carritoRepository;
    
    public List<Carrito> getAll(){
        List<Carrito> carritos = new ArrayList<>();
        for (Carrito carrito : carritoRepository.findAll()) {
            carritos.add(carrito);
        }
        return carritos;
    }
    
    public void add(Carrito carrito){
        carritoRepository.save(carrito);
    }
}
