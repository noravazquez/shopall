package mx.itc.shopall.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.itc.shopall.model.Carrito;

@Repository
public interface CarritoRepository extends CrudRepository<Carrito, Integer>{
    
}
