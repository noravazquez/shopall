package mx.itc.shopall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.itc.shopall.model.ResenaProducto;
import mx.itc.shopall.repository.ResenaProductoRepository;

@Service
public class ResenaProductoService {
    @Autowired
    ResenaProductoRepository resenaProductoRepository;
    
    public List<ResenaProducto> getAll(){
        List<ResenaProducto> resenasProducto = new ArrayList<>();
        for (ResenaProducto resenaProducto : resenaProductoRepository.findAll()) {
            resenasProducto.add(resenaProducto);
        }
        return resenasProducto;
    }
    
    public void add(ResenaProducto resenaProducto){
        resenaProductoRepository.save(resenaProducto);
    }
}
