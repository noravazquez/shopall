package mx.itc.shopall.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.itc.shopall.model.Usuario;
import mx.itc.shopall.repository.UsuarioRepository;

@Service
public class UsuarioDetailService implements UserDetailsService{
    @Autowired
    private UsuarioRepository usuarioRepository;

    //private static final Logger LOG = LoggerFactory.getLogger(UsuarioDetailService.class);

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Usuario usuario = usuarioRepository.login(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Not exist");
        }
        //BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        Set <GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(
            usuario.getRol().getDescripcion()));
        UserDetails userDetails = 
            new org.springframework.security.core.userdetails.User(
                usuario.getUsername(),
                 usuario.getPassword(), 
                 true, true, true, true, grantedAuthorities);
        return userDetails;
    }
}
