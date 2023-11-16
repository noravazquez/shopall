package mx.itc.shopall.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.itc.shopall.model.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Integer>{
    
}
