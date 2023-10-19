package mx.itc.shopall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.itc.shopall.model.Vendedor;
import mx.itc.shopall.repository.VendedorRepository;

@Service
public class VendedorService {
    @Autowired
    VendedorRepository vendedorRepository;

    public List<Vendedor> getAll(){
        List<Vendedor> vendedores = new ArrayList<>();
        for(Vendedor vendedor : vendedorRepository.findAll()){
            vendedores.add(vendedor);
        }
        return vendedores;
    }

    public void add(Vendedor vendedor){
        vendedorRepository.save(vendedor);
    }
}
