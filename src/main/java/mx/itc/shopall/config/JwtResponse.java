package mx.itc.shopall.config;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.itc.shopall.model.Usuario;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    private String token;
    private String username;
    private List<String> rol;
    private Usuario usuario;
}
