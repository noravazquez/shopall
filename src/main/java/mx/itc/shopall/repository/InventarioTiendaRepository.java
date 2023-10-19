package mx.itc.shopall.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.itc.shopall.model.InventarioTienda;

@Repository
public interface InventarioTiendaRepository extends CrudRepository<InventarioTienda, Integer>{
    
}
