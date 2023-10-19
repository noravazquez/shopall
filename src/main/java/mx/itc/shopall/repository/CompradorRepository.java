package mx.itc.shopall.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.itc.shopall.model.Comprador;

@Repository
public interface CompradorRepository extends CrudRepository<Comprador, Integer>{
    
}
