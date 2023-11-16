package mx.itc.shopall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.itc.shopall.model.DetalleCarrito;
import mx.itc.shopall.repository.DetalleCarritoRepository;

@Service
public class DetalleCarritoService {
    @Autowired
    DetalleCarritoRepository detalleCarritoRepository;
    
    public List<DetalleCarrito> getAll(){
        List<DetalleCarrito> detallesCarrito = new ArrayList<>();
        for (DetalleCarrito detalleCarrito : detalleCarritoRepository.findAll()) {
            detallesCarrito.add(detalleCarrito);
        }
        return detallesCarrito;
    }
    
    public void add(DetalleCarrito detalleCarrito){
        detalleCarritoRepository.save(detalleCarrito);
    }

    public DetalleCarrito getById(int id){
        return detalleCarritoRepository.findById(id).orElse(null);
    }

    public void update(int id, DetalleCarrito detalleCarrito){
        if (detalleCarritoRepository.existsById(id)) {
            detalleCarrito.setId_detalle_carrito(id);
            detalleCarritoRepository.save(detalleCarrito);
        }
    }

    public void delete(int id){
        detalleCarritoRepository.deleteById(id);
    }
}
