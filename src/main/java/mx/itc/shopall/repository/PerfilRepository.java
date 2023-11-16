package mx.itc.shopall.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.itc.shopall.model.Perfil;

@Repository
public interface PerfilRepository extends CrudRepository<Perfil, Integer>{
    
}
