package mx.itc.shopall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.itc.shopall.model.Usuario;
import mx.itc.shopall.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioContoller {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/add")
    public void add(@RequestBody Usuario bodyUsuario){
        usuarioService.add(bodyUsuario);
    }

    @GetMapping("/getAll")
    public List<Usuario> getAll(){
        return usuarioService.getAll();
    }
}
