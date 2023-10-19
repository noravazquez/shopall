package mx.itc.shopall.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.itc.shopall.model.ResenaProducto;

@Repository
public interface ResenaProductoRepository extends CrudRepository<ResenaProducto, Integer>{
    
}
