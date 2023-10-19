package mx.itc.shopall.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
    @Id
    @Column(name = "id_usuario")
    private int id_usuario;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "contrasena")
    private String contrasena;
    @Column(name = "email")
    private String email;
}
