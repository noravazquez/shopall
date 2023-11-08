package mx.itc.shopall.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.itc.shopall.model.Rol;

@Repository
public interface RolRepository extends CrudRepository<Rol, Integer>{
    
}
