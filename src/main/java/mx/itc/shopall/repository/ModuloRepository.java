package mx.itc.shopall.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.itc.shopall.model.Modulo;

@Repository
public interface ModuloRepository extends CrudRepository<Modulo, Integer>{
    
}
