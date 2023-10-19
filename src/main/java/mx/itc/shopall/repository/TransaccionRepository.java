package mx.itc.shopall.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.itc.shopall.model.Transaccion;

@Repository
public interface TransaccionRepository extends CrudRepository<Transaccion, Integer>{
    
}
