package mx.itc.shopall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.itc.shopall.model.Usuario;
import mx.itc.shopall.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> getAll(){
        List<Usuario> usuarios = new ArrayList<>();
        for(Usuario usuario : usuarioRepository.findAll()){
            usuarios.add(usuario);
        }
        return usuarios;
    }

    public void add(Usuario usuario){
        usuarioRepository.save(usuario);
    }
}