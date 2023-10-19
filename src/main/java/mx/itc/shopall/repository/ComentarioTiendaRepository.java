package mx.itc.shopall.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.itc.shopall.model.ComentarioTienda;

@Repository
public interface ComentarioTiendaRepository extends CrudRepository<ComentarioTienda, Integer>{
    
}
