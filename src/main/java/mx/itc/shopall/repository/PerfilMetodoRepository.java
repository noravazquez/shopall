package mx.itc.shopall.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.itc.shopall.model.PerfilMetodo;

@Repository
public interface PerfilMetodoRepository extends CrudRepository<PerfilMetodo, Integer>{
    
}
