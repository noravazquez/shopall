package mx.itc.shopall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.itc.shopall.model.Producto;
import mx.itc.shopall.repository.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository productoRepository;
    
    public List<Producto> getAll(){
        List<Producto> productos = new ArrayList<>();
        for (Producto producto : productoRepository.findAll()) {
            productos.add(producto);
        }
        return productos;
    }
    
    public void add(Producto producto){
        productoRepository.save(producto);
    }

    public Producto getById(int id){
        return productoRepository.findById(id).orElse(null);
    }

    public void update(int id, Producto producto){
        if (productoRepository.existsById(id)) {
            producto.setId_producto(id);
            productoRepository.save(producto);
        }
    }

    public void delete(int id){
        productoRepository.deleteById(id);
    }
}
