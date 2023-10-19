package mx.itc.shopall.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.itc.shopall.model.ComentarioProducto;

@Repository
public interface ComentarioProductoRepository extends CrudRepository<ComentarioProducto, Integer>{
    
}
