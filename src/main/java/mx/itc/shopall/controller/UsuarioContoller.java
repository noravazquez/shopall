package mx.itc.shopall.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.itc.shopall.model.AuthRequest;
import mx.itc.shopall.model.Usuario;
import mx.itc.shopall.service.JwtService;
import mx.itc.shopall.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioContoller {
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioContoller.class);

    @PostMapping("/add")
    public void add(@RequestBody Usuario bodyUsuario){
        usuarioService.add(bodyUsuario);
        LOGGER.info("Usuario agregado correctamente.");
    }

    @GetMapping("/getAll")
    public List<Usuario> getAll(){
        LOGGER.info("Usuarios obtenidos correctamente");
        return usuarioService.getAll();
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("Invalid user request");
        }
    }
}
