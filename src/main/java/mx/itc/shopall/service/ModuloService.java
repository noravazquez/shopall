package mx.itc.shopall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.itc.shopall.model.Modulo;
import mx.itc.shopall.repository.ModuloRepository;

@Service
public class ModuloService {
    @Autowired
    ModuloRepository moduloRepository;

    public List<Modulo> getAll(){
        List<Modulo> modulos = new ArrayList<>();
        for(Modulo modulo : moduloRepository.findAll()){
            modulos.add(modulo);
        }
        return modulos;
    }
}
