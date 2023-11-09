package mx.itc.shopall.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.itc.shopall.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
    @Query("SELECT u FROM Usuario u WHERE u.username = ?1")
    public Usuario login(String username);
}
