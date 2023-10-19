package mx.itc.shopall.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.itc.shopall.model.DetalleCarrito;

@Repository
public interface DetalleCarritoRepository extends CrudRepository<DetalleCarrito, Integer>{
    
}
