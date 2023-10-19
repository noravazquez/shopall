package mx.itc.shopall.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.itc.shopall.model.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Integer>{
    
}
