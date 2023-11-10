package mx.itc.shopall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails; 
import org.springframework.security.core.userdetails.UserDetailsService; 
import org.springframework.security.core.userdetails.UsernameNotFoundException; 
import org.springframework.security.crypto.password.PasswordEncoder; 
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import mx.itc.shopall.model.Usuario;
import mx.itc.shopall.repository.UsuarioRepository;

@Service
@Lazy
public class UsuarioService implements UserDetailsService{
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder encoder;

    public List<Usuario> getAll(){
        List<Usuario> usuarios = new ArrayList<>();
        for(Usuario usuario : usuarioRepository.findAll()){
            usuarios.add(usuario);
        }
        return usuarios;
    }

    public void add(Usuario usuario){
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        usuarioRepository.save(usuario);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<Usuario> userDetail = usuarioRepository.findByUsername(username);

        return userDetail.map(UsuarioDetails::new)
            .orElseThrow(() -> new UsernameNotFoundException("User not found" + username));
    }
}
