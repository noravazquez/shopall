package mx.itc.shopall.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.itc.shopall.model.Metodo;

@Repository
public interface MetodoRepository extends CrudRepository<Metodo, Integer>{
    
}
