package mx.itc.shopall.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.itc.shopall.model.Tienda;

@Repository
public interface TiendaRepository extends CrudRepository<Tienda, Integer>{
    
}
