package mx.itc.shopall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.itc.shopall.model.Rol;
import mx.itc.shopall.repository.RolRepository;

@Service
public class RolService {
    @Autowired
    RolRepository rolRepository;

    public List<Rol> getAll(){
        List<Rol> roles = new ArrayList<>();
        for(Rol rol : rolRepository.findAll()){
            roles.add(rol);
        }
        return roles;
    }
}
