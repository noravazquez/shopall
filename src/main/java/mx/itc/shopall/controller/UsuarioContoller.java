package mx.itc.shopall.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.itc.shopall.configuration.JwtResponse;
import mx.itc.shopall.configuration.JwtUtils;
import mx.itc.shopall.domain.UsuarioDTO;
import mx.itc.shopall.model.Usuario;
import mx.itc.shopall.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioContoller {
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtils jwtUtils;

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioContoller.class);

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome this endpoint is not secure";
    }

    @GetMapping("/getAll")
    public List<Usuario> getAll(){
        LOGGER.info("Usuarios encontrados correctamente.");
        return usuarioService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody Usuario body) {
        LOGGER.info("Usuario agregado correctamente.");
        usuarioService.add(body);
    }

    @PostMapping("/token")
    public ResponseEntity<?> authenticateUser(@RequestBody UsuarioDTO usuarioDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuarioDTO.getUsername(),
                        //"{bcrypt}"+bcrypt.encode(usuarioDTO.getPassword())));       
                        usuarioDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication, usuarioService.login(usuarioDTO.getUsername()));

        User userDetails = (User) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getUsername(),
                roles,jwtUtils.getUserData(jwt)));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable int id){
        Usuario usuario = usuarioService.getById(id);
        if (usuario != null) {
            LOGGER.info("Registro encontrado correctamente.");
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Usuario usuario){
        Usuario oldUsuario = usuarioService.getById(id);
        if (oldUsuario != null) {
            usuarioService.update(id, usuario);
            LOGGER.info("Registro actualizado correctamente.");
            return new ResponseEntity<>("Registro actualizado correctamente", HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>("Registro no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        Usuario usuario = usuarioService.getById(id);
        if (usuario != null) {
            usuarioService.delete(id);
            LOGGER.info("Registro eliminado correctamente.");
            return new ResponseEntity<>("Registrado eliminado", HttpStatus.OK);
        }else{
            LOGGER.error("Registro no encontrado correctamente.");
            return new ResponseEntity<>("Resgistro no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
